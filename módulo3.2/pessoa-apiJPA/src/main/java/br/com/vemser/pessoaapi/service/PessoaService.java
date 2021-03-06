package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.enums.TipoEmail;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
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
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException, TemplateException, IOException {

        log.info("Criando a pessoa...");
        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaRepository.save(convertPessoaEntity(pessoa)));
        log.info("PessoaEntity " + pessoaDTO.getNome() + " criada!");
        String emailTipo = TipoEmail.CREATE.getTipo();
        emailService.sendEmailPessoa(pessoaDTO, emailTipo);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::convertPessoaDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException, TemplateException, IOException {

        log.info("Alterando a pessoa...");
        PessoaEntity pessoaAtualizada = findByIdPessoa(id);
        pessoaAtualizada.setCpf(pessoaAtualizar.getCpf());
        pessoaAtualizada.setNome(pessoaAtualizar.getNome());
        pessoaAtualizada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaAtualizada.setEmail(pessoaAtualizar.getEmail());
        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaRepository.save(convertPessoaEntity(pessoaAtualizar)));
        log.info("PessoaEntity " + pessoaAtualizada.getNome() + " alterada!");
        String emailTipo = TipoEmail.PUT.getTipo();
        emailService.sendEmailPessoa(pessoaDTO, emailTipo);
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        PessoaEntity pessoaRecuperada = findByIdPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaRecuperada);
        String emailTipo = TipoEmail.DELETE.getTipo();
        emailService.sendEmailPessoa(pessoaDTO, emailTipo);
        log.warn("Deletando a pessoa...");
        log.info("PessoaEntity id " + id + " deletada!");
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
        log.info("Listando pessoa pelo nome...");
        if(findByName(nome).isEmpty()){
            log.info("Nome n??o encontrado");
            throw new RegraDeNegocioException("Nome n??o encontrado");
        } else {
            log.info("Nome encontrado...");
            return findByName(nome).stream()
                    .map(this::convertPessoaDTO)
                    .collect(Collectors.toList());
        }
    }

    public PessoaEntity findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
       return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("PessoaEntity n??o encontrada"));
    }

    //Teste para verificar se consigo recuperar pessoa pelo nome
    public List<PessoaEntity> findByName(String nome) throws RegraDeNegocioException {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public PessoaEntity convertPessoaEntity(PessoaCreateDTO pessoaCreateDTO) {
        return objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
    }

    public PessoaDTO convertPessoaDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public List<PessoaDTO> findByNomeIgnoreCase(String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome).stream()
                .map(this::convertPessoaDTO)
                .toList();
    }

    public List<PessoaDTO> findByCpf(String nome) throws RegraDeNegocioException {
        return pessoaRepository.findByCpf(nome).stream()
                .map(this::convertPessoaDTO)
                .toList();
    }

    public List<PessoaDTO> listContatos(Integer idPessoa) throws RegraDeNegocioException {
        if(idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> {
                    PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                    pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                            .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                            .toList());
                    return pessoaDTO;
                }).toList();
    }}

    public List<PessoaDTO> listEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listPet(Integer idPessoa) throws RegraDeNegocioException {
        if(idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity, PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity, PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }

//    public List<PessoaDTO> listAllMesmo(Integer idPessoa) throws RegraDeNegocioException {
//        if(idPessoa != null) {
//            return pessoaRepository.findById(idPessoa).stream()
//                    .map(pessoaEntity -> {
//                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
//                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity, PetDTO.class));
//                        pessoaDTO.setEnderecoDTOS(pessoaDTO.getEnderecoDTOS());
//                        pessoaDTO.setContatoDTOS(pessoaDTO.getContatoDTOS());
//                        return pessoaDTO;
//                    }).toList();
//        } else {
//            return pessoaRepository.findAll().stream()
//                    .map(pessoaEntity -> {
//                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
//                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity, PetDTO.class));
//                        pessoaDTO.setEnderecoDTOS(pessoaDTO.getEnderecoDTOS());
//                        pessoaDTO.setContatoDTOS(pessoaDTO.getContatoDTOS());
//                        return pessoaDTO;
//                    }).toList();
//        }
//    }

    public List<PessoaDTO> listAllMesmo(Integer idPessoa) throws RegraDeNegocioException {
        if(idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertPessoaDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }
    public List<RelatorioPersonalizadoDTO> relatorioPersonalizadoDTO (Integer idPessoa){
        return pessoaRepository.listRelatorioDTO(idPessoa);
    }

    public PessoaEntity salvar(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }
}
