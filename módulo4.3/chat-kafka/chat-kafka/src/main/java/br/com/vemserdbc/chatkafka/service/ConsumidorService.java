package br.com.vemserdbc.chatkafka.service;

import br.com.vemserdbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
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
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat-geral")
    public void consumir(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(mensagemDTO.getDataCriacao().format(formatter) + " [ " + mensagemDTO.getUsuario() + " ]: " + mensagemDTO.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic-privado}",
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "paulo")
    public void consumirSensor(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(mensagemDTO.getDataCriacao().format(formatter) + " [" + mensagemDTO.getUsuario() + "] " + "(privada): " + mensagemDTO.getMensagem());    }
}
