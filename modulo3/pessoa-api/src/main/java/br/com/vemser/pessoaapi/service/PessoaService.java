package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create(Pessoa pessoa) throws Exception {
        boolean pessoaExiste = ObjectUtils.isEmpty(pessoa.getDataNascimento());
        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
        boolean cpfEmBranco = StringUtils.isBlank(pessoa.getCpf());

        if (!nomeEmBranco && !pessoaExiste && !cpfEmBranco && pessoa.getCpf().length() == 11) {
            return pessoaRepository.create(pessoa);
        } else {
            throw new Exception("Pessoa não foi criada");
        }
    }

    public List<Pessoa> list (){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception{
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
