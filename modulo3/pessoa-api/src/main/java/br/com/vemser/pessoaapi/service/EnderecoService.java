package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {

        log.info("Criando o endereço...");
        pessoaService.findByIdPessoa(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        enderecoEntity = enderecoRepository.create(enderecoEntity);
        enderecoEntity.setIdPessoa(idPessoa);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        log.info("Endereço da pessoa " + idPessoa + " criado!");
        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        List<Endereco> enderecosEntity = enderecoRepository.list();
        for (Endereco endereco : enderecosEntity){
            enderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        pessoaService.findByIdPessoa(enderecoAtualizar.getIdPessoa());

        Endereco enderecoAtualizado = finByIdEndereco(id);
        enderecoAtualizado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoAtualizado.setTipo(enderecoAtualizar.getTipo());
        enderecoAtualizado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoAtualizado.setNumero(enderecoAtualizar.getNumero());
        enderecoAtualizado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoAtualizado.setCep(enderecoAtualizar.getCep());
        enderecoAtualizado.setCidade(enderecoAtualizar.getCidade());
        enderecoAtualizado.setEstado(enderecoAtualizar.getEstado());
        enderecoAtualizado.setPais(enderecoAtualizar.getPais());

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
        log.info("Alterando endereço...");
        log.info("Endereço " + enderecoAtualizado.getIdPessoa() + " alterado!");
        return enderecoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        log.warn("Deletando o endereço...");
        log.info("Endereço " + id + " deletado!");
    }

    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        List<Endereco> enderecosEntity = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
        for (Endereco endereco : enderecosEntity){
            enderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTO;
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        List<EnderecoDTO> enderecosDTOS = new ArrayList<>();
        List<Endereco> enderecosEntity = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).toList();
        for (Endereco endereco : enderecosEntity){
            enderecosDTOS.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTOS;
    }

    public Endereco finByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoById = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoById;
    }
}

