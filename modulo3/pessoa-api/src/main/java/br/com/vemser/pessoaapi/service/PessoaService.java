package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
//        boolean pessoaExiste = ObjectUtils.isEmpty(pessoa.getDataNascimento());
//        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
////        boolean cpfEmBranco = StringUtils.isBlank(pessoa.getCpf());
//
//        if (!nomeEmBranco && !pessoaExiste && !cpfEmBranco && pessoa.getCpf().length() == 14) {
        log.info("Criando a pessoa...");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO;
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        log.info("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
//        } else {
//            throw new RegraDeNegocioException("Pessoa não foi criada");
//        }
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        //Somente um teste
//        findByName(String.valueOf(pessoaAtualizar));
        objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaRecuperada = list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaDTO pessoaDTO;
        pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
        log.info("Alterando a pessoa...");
        log.info("Pessoa " + pessoaRecuperada.getNome() + " alterada!");
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        log.warn("Deletando a pessoa...");
        log.info("Pessoa id " + id + " deletada!");
    }

    public List<PessoaDTO> listByName(String nome) {
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        List<Pessoa> pessoas = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
        for (Pessoa pessoa : pessoas) {
            pessoasDTO.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return pessoasDTO;
    }

    public PessoaDTO findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        objectMapper.convertValue(idPessoa, Pessoa.class);
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        PessoaDTO pessoaDTO;
        pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
        return pessoaDTO;
    }

    //Teste para verificar se consigo recuperar pessoa pelo nome
//    public PessoaDTO findByName(String nome) throws RegraDeNegocioException {
//        objectMapper.convertValue(nome, Pessoa.class);
//        Pessoa pessoaNomeRecuperado = pessoaRepository.list().stream()
//                .filter(pessoa -> pessoa.getNome().equals(nome))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Nome da Pessoa não encontrado"));
//        PessoaDTO pessoaDTO;
//        pessoaDTO = objectMapper.convertValue(pessoaNomeRecuperado, PessoaDTO.class);
//        return pessoaDTO;
//    }
}
