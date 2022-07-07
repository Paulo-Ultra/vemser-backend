package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(idPessoa, endereco);
    }

    @GetMapping
    public List<Endereco> list (){
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco (@PathVariable ("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa (@PathVariable ("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id, @RequestBody Endereco enderecoAtualizar) throws Exception{
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
