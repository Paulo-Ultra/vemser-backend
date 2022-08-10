package br.com.vemserdbc.chatkafka.controller;

import br.com.vemserdbc.chatkafka.dto.MensagemDTO;
import br.com.vemserdbc.chatkafka.enums.OpcoesEnvio;
import br.com.vemserdbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-geral")
    public ResponseEntity<Void> enviarMensagem(@RequestBody MensagemDTO mensagem, @RequestParam List<OpcoesEnvio> listaEnvio) throws JsonProcessingException {
       produtorService.enviarMensagemGeral(mensagem, listaEnvio);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
