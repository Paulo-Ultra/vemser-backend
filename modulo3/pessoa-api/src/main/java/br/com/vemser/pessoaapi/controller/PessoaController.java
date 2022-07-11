package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private PessoaService pessoaService;

    //Modelo mais novo
//    private final PessoaService pessoaService;

    //Modelo mais novo
//    public PessoaController(PessoaService pessoaService){
//        this.pessoaService = pessoaService;
//    }

    @GetMapping("/ambiente")
    public String getAmbiente(){
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello") //localhost:8080/pessoa/hello
    public String hello(){
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
//        return ResponseEntity.ok(pessoaService.create(pessoa));
        //Um ou outro

        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PessoaDTO> list (){
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Paulo
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException{
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
