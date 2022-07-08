package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create(Pessoa pessoa) throws Exception {
//        boolean pessoaExiste = ObjectUtils.isEmpty(pessoa.getDataNascimento());
//        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
////        boolean cpfEmBranco = StringUtils.isBlank(pessoa.getCpf());
//
//        if (!nomeEmBranco && !pessoaExiste && !cpfEmBranco && pessoa.getCpf().length() == 14) {
        return pessoaRepository.create(pessoa);
//        } else {
//            throw new RegraDeNegocioException("Pessoa não foi criada");
//        }
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        //Somente um teste
//        findByName(String.valueOf(pessoaAtualizar));
        Pessoa pessoaRecuperada = list().stream()
                    .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<Pessoa> listByName(String nome) {
        return list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Pessoa findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaRecuperada;
    }

    //Teste para verificar se consigo recuperar pessoa pelo nome
//    public Pessoa findByName(String nome) throws RegraDeNegocioException {
//        Pessoa pessoaNomeRecuperado = pessoaRepository.list().stream()
//                .filter(pessoa -> pessoa.getNome().equals(nome))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Nome da Pessoa não encontrado"));
//        return pessoaNomeRecuperado;
//    }
}
