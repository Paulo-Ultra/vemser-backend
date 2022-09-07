package br.com.vemserdbc.chatkafka.service;

import br.com.vemserdbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic-mensagem}", partitions = {"0", "11"})},
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat-geral")
    public void consumir(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer particao) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        imprimirMensagemChat(mensagemDTO, particao);
    }

    public void imprimirMensagemChat (MensagemDTO mensagemDTO, Integer particao) {
        String data = mensagemDTO.getDataCriacao().format(formatter);
        String usuario = mensagemDTO.getUsuario();
        String mensagem = mensagemDTO.getMensagem();
        if(particao == 0){
            log.info(data + " [ " + usuario + " ]: " + mensagem);
        } else {
            log.info(data + " [ " + usuario + " ](privado): " + mensagem);
        }
    }

//
//    @KafkaListener(
//            topics = "${kafka.topic-privado}",
//            groupId = "${kafka.user}",
//            topicPartitions = {@TopicPartition(topic = "${kafka.topic-mensagem}", partitions = {"11"})},
//            containerFactory = "listenerContainerFactory",
//            clientIdPrefix = "paulo")
//    public void consumirSensor(@Payload String mensagem) throws JsonProcessingException {
//        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
//        log.info(mensagemDTO.getDataCriacao().format(formatter) + " [" + mensagemDTO.getUsuario() + "] " + "(privada): " + mensagemDTO.getMensagem());    }
}
