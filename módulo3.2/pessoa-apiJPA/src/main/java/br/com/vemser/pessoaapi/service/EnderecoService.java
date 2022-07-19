package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
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

    public EnderecoDTO create(EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {

        log.info("Criando o endereço...");

        EnderecoEntity enderecoEntity = convertEnderecoEntity(endereco);
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        log.info("Endereço da pessoa " + enderecoEntity + " criado!");
//        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
//        String emailTipo = TipoEmail.CREATE.getTipo();
//        emailService.sendEmailEndereco(pessoa, enderecoDTO, emailTipo);
        return convertEnderecoDTO(enderecoEntity);
    }

    public List<EnderecoDTO> list() {
             return enderecoRepository.findAll().stream()
                     .map(this::convertEnderecoDTO)
                     .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException, TemplateException, IOException {
//        PessoaEntity pessoa = pessoaService.findByIdPessoa(id);

        EnderecoEntity enderecoAtualizado = finByIdEndereco(id);
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
        return convertEnderecoDTO(enderecoRepository.save(enderecoAtualizado));
//        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
//        String emailTipo = TipoEmail.PUT.getTipo();
//        emailService.sendEmailEndereco(pessoa, enderecoDTO, emailTipo);
//        return enderecoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        EnderecoEntity enderecoRecuperado = finByIdEndereco(id);
       enderecoRepository.delete(enderecoRecuperado);
        log.warn("Deletando o endereço...");
        log.info("Endereço " + id + " deletado!");
//        PessoaEntity pessoaRecuperada = pessoaService.findByIdPessoa(enderecoRecuperado.getIdPessoa());
//        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
//        String emailTipo = TipoEmail.DELETE.getTipo();
//        emailService.sendEmailEndereco(pessoaRecuperada, enderecoDTO, emailTipo);
    }

    public EnderecoDTO listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return objectMapper.convertValue(finByIdEndereco(idEndereco), EnderecoDTO.class);
        }

    public EnderecoEntity finByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoById = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoById;
    }

    public EnderecoEntity convertEnderecoEntity(EnderecoCreateDTO enderecoCreateDTO) {
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }

    public EnderecoDTO convertEnderecoDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }
}

