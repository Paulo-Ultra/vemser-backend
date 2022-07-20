package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.enums.TipoEmail;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {

        log.info("Criando o endereço...");
        PessoaEntity pessoa = pessoaService.findByIdPessoa(idPessoa);
        EnderecoEntity enderecoEntity = convertEnderecoEntity(endereco);
        enderecoEntity.setPessoas(Set.of(pessoa));

        enderecoEntity = enderecoRepository.save(enderecoEntity);
        log.info("Endereço da pessoa " + enderecoEntity + " criado!");
        EnderecoDTO enderecoDTO = convertEnderecoDTO(enderecoEntity);
        String emailTipo = TipoEmail.CREATE.getTipo();
        emailService.sendEmailEndereco(pessoa, enderecoDTO, emailTipo);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
             return enderecoRepository.findAll().stream()
                     .map(this::convertEnderecoDTO)
                     .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException, TemplateException, IOException {
        PessoaEntity pessoa = pessoaService.findByIdPessoa(enderecoAtualizar.getIdPessoa());

        EnderecoEntity enderecoAtualizado = finByIdEndereco(id);
        enderecoAtualizado.setPessoas(Set.of(pessoa));
//        enderecoAtualizado.setTipo(enderecoAtualizar.getTipo());
//        enderecoAtualizado.setLogradouro(enderecoAtualizar.getLogradouro());
//        enderecoAtualizado.setNumero(enderecoAtualizar.getNumero());
//        enderecoAtualizado.setComplemento(enderecoAtualizar.getComplemento());
//        enderecoAtualizado.setCep(enderecoAtualizar.getCep());
//        enderecoAtualizado.setCidade(enderecoAtualizar.getCidade());
//        enderecoAtualizado.setEstado(enderecoAtualizar.getEstado());
//        enderecoAtualizado.setPais(enderecoAtualizar.getPais());

        log.info("Alterando endereço...");
        log.info("Endereço " + enderecoAtualizado.getIdEndereco() + " alterado!");
        String emailTipo = TipoEmail.PUT.getTipo();
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
        emailService.sendEmailEndereco(pessoa, enderecoDTO, emailTipo);
        return convertEnderecoDTO(enderecoRepository.save(enderecoAtualizado));
    }

    public void delete(Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        EnderecoEntity enderecoRecuperado = finByIdEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
        log.warn("Deletando o endereço...");
        log.info("Endereço " + id + " deletado!");
        Set<PessoaEntity> pessoaRecuperada = enderecoRecuperado.getPessoas();
        EnderecoDTO enderecoDTO = convertEnderecoDTO(enderecoRecuperado);
        String emailTipo = TipoEmail.DELETE.getTipo();
        emailService.sendEmailEndereco((PessoaEntity) pessoaRecuperada, enderecoDTO, emailTipo);
    }

    public EnderecoDTO listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return objectMapper.convertValue(finByIdEndereco(idEndereco), EnderecoDTO.class);
        }

    public EnderecoEntity finByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoById = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoById;
    }

        public List<EnderecoDTO> listByIdPessoa(@Valid EnderecoCreateDTO enderecoCreateDTO, Integer idPessoa) {
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getPessoas().equals(idPessoa))
                .map(this::convertEnderecoDTO)
                .toList();
    }

    public EnderecoEntity convertEnderecoEntity(EnderecoCreateDTO enderecoCreateDTO) {
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }

    public EnderecoDTO convertEnderecoDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }
}

