package br.com.vemserdbc.veiculoprodutorconsumidor.service;

import br.com.vemserdbc.veiculoprodutorconsumidor.dto.SensorVeiculoDTO;
import br.com.vemserdbc.veiculoprodutorconsumidor.entity.SensorVeiculoEntity;
import br.com.vemserdbc.veiculoprodutorconsumidor.repository.SensorVeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {

    private final SensorVeiculoRepository sensorVeiculoRepository;
    private final KafkaTemplate kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Value("${kafka.topic}")
    private String topico;

    @Value("${kafka.topic-veiculo}")
    private String topicoVeiculo;

    public void enviarMensagemObjeto(SensorVeiculoDTO sensorVeiculoDTO) throws JsonProcessingException {
        String sensorObjetoString = objectMapper.writeValueAsString(sensorVeiculoDTO);
        enviarMensagemKafka(sensorObjetoString, topicoVeiculo);
    }

    public void enviarMensagemString(String mensagem) {
        enviarMensagemKafka(mensagem, topico);
    }

    private void enviarMensagemKafka(String mensagem, String topico) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        Message<String> stringMessage = stringMessageBuilder
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
            }

            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", mensagem);
            }
        });
    }

    public List<SensorVeiculoDTO> getAllSensorVeiculos() {
        return sensorVeiculoRepository.findAll().stream()
                .map(sensorVeiculoEntity -> {
                    SensorVeiculoDTO sensorVeiculoDTO = convertDTO(sensorVeiculoEntity);
                    return sensorVeiculoDTO;
                }).toList();
    }



    public SensorVeiculoDTO convertDTO (SensorVeiculoEntity sensorVeiculoEntity){
        return objectMapper.convertValue(sensorVeiculoEntity, SensorVeiculoDTO.class);
    }
}
