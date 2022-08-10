package br.com.vemserdbc.veiculoprodutorconsumidor.service;

import br.com.vemserdbc.veiculoprodutorconsumidor.dto.SensorVeiculoDTO;
import br.com.vemserdbc.veiculoprodutorconsumidor.entity.SensorVeiculoEntity;
import br.com.vemserdbc.veiculoprodutorconsumidor.repository.SensorVeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;
    private final SensorVeiculoRepository sensorVeiculoRepository;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consumir(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}' ", offset, key, mensagem);
    }

    @KafkaListener(
            topics = "${kafka.topic-veiculo}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "sensor")
    public void consumirSensor(@Payload String mensagem,
                               @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                               @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        SensorVeiculoDTO sensorVeiculoDTO = objectMapper.readValue(mensagem, SensorVeiculoDTO.class);
        sensorVeiculoRepository.save(objectMapper.convertValue(sensorVeiculoDTO, SensorVeiculoEntity.class));
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, sensorVeiculoDTO);
    }

}
