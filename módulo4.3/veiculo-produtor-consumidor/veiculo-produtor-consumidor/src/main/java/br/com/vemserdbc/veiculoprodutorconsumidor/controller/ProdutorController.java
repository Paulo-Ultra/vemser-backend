package br.com.vemserdbc.veiculoprodutorconsumidor.controller;

import br.com.vemserdbc.veiculoprodutorconsumidor.dto.SensorVeiculoDTO;
import br.com.vemserdbc.veiculoprodutorconsumidor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public ResponseEntity<Void> enviarMensagemParaOTopico(String mensagem) {
       produtorService.enviarMensagemString(mensagem);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/enviar-sensor")
    public ResponseEntity<Void> enviarMensagemParaOSensor(@RequestBody SensorVeiculoDTO sensorVeiculoDTO) throws JsonProcessingException {
        produtorService.enviarMensagemObjeto(sensorVeiculoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SensorVeiculoDTO>> list(){
        return new ResponseEntity<>(produtorService.getAllSensorVeiculos(), HttpStatus.OK);
    }
}
