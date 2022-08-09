package br.com.vemserdbc.produtorconsumidor.controller;

import br.com.vemserdbc.produtorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public ResponseEntity<Void> enviarMensagemParaOTopico(String mensagem) {
       produtorService.enviarMensagemKafka(mensagem);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
