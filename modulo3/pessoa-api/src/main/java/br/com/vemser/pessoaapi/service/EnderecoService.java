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
        log.info("Endereço da pessoa " + idPessoa + " criado!");
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public List<EnderecoDTO> list() {
             return enderecoRepository.list().stream()
                     .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                     .collect(Collectors.toList());
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

        log.info("Alterando endereço...");
        log.info("Endereço " + enderecoAtualizado.getIdEndereco() + " alterado!");
        return objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
       Endereco enderecoRecuperado = finByIdEndereco(id);
       enderecoRepository.list().remove(enderecoRecuperado);
        log.warn("Deletando o endereço...");
        log.info("Endereço " + id + " deletado!");
    }

    public EnderecoDTO listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return objectMapper.convertValue(finByIdEndereco(idEndereco), EnderecoDTO.class);
        }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        pessoaService.findByIdPessoa(idPessoa);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public Endereco finByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoById = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoById;
    }
}

