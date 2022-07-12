package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EnderecoDTO> list (){
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> listByIdEndereco (@PathVariable ("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.listByIdEndereco(idEndereco), HttpStatus.OK);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa (@PathVariable ("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.listByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id, @RequestBody @Valid EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        enderecoService.delete(id);
    }

}
