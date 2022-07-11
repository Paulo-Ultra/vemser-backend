package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    //Modelo mais novo
//    private final ContatoService contatoService;

    //Modelo mais novo
//        public ContatoController(){
//        contatoService = new ContatoService();
//    }

    @Autowired
    private ContatoService contatoService;

//    public ContatoController(ContatoService contatoService){
//        this.contatoService = contatoService;
//    }

    @PostMapping ("/{idPessoa}")//localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable ("idPessoa") Integer idPessoa, @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.CREATED);
    }

    @GetMapping //localhost:8080/contato
    public List<ContatoDTO> list (){
        return contatoService.list();
    }

    @GetMapping("/byIdPessoa") //localhost:8080/contato/byIdPessoa?idPessoa=1
    public ResponseEntity<List<ContatoDTO>> listByIdPessoaParams (@RequestParam("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.listByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}") //localhost:8080/contato/2
    public ResponseEntity<List<ContatoDTO>> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.listByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException{
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}
