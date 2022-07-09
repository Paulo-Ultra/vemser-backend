package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
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
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException {
        pessoaService.findByIdPessoa(idPessoa);
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        contatoEntity = contatoRepository.create(idPessoa, contatoEntity);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        log.info("Criando o contato...");
        log.info("Contato da pessoa " + contatoEntity.getIdPessoa() + " criado!");
        return contatoDTO;
    }

    public List<ContatoDTO> list (){
        List<ContatoDTO> contatosDTO = new ArrayList<>();
        List<Contato> contatosEntity = contatoRepository.list();
        for (Contato contato : contatosEntity){
            contatosDTO.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        return contatosDTO;
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException{

        Contato contatoAtualizado = findByIdContato(id);
        pessoaService.findByIdPessoa(contatoAtualizar.getIdPessoa());
        contatoAtualizado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoAtualizado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoAtualizado.setNumero(contatoAtualizar.getNumero());
        contatoAtualizado.setDescricao(contatoAtualizar.getDescricao());

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
        log.info("Alterando contato...");
        log.info("Contato " + contatoAtualizado.getIdContato() + " alterado!");
        return contatoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        log.warn("Deletando o contato...");
        log.info("Contato " + id + " deletado!");
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        List<ContatoDTO> contatosDTO = new ArrayList<>();
        List<Contato> contatosEntity = contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        for (Contato contato : contatosEntity){
            contatosDTO.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        return contatosDTO;
    }

    public Contato findByIdContato(Integer idContato) throws RegraDeNegocioException {
        Contato contatoById = contatoRepository.list().stream()
                .filter(endereco -> endereco.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoById;
    }
}

