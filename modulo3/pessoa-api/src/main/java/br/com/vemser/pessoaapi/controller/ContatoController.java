package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(){
        contatoService = new ContatoService();
    }

    @PostMapping //localhost:8080/contato
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping //localhost:8080/contato
    public List<Contato> list (){
        return contatoService.list();
    }

    //Fiquei na dúvida qual era para criar ao certo criei com parãmetro também
    @GetMapping("/byIdPessoa") //localhost:8080/contato/byIdPessoa?idPessoa=1
    public List<Contato> listByIdPessoaParams (@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{idPessoa}") //localhost:8080/contato/2
    public List<Contato> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody Contato contatoAtualizar) throws Exception{
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}