package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class PetService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::convertPetDTO)
                .toList();
    }

    public PetDTO create(PetCreateDTO pet) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("Criando o pet...");
        PetEntity petEntity = convertPetEntity(pet);
        petEntity.setPessoa(pessoaService.findByIdPessoa(pet.getIdPessoa()));
        PetDTO petDTO = convertPetDTO(petRepository.save(petEntity));
        return petDTO;
    }

    public PetDTO update(PetCreateDTO petAtualizar, Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        PessoaEntity pessoa = pessoaService.findByIdPessoa(petAtualizar.getIdPessoa());
        log.info("Criando o pet...");

        PetEntity petEntityAtualizado = findByIdPet(id);
        petEntityAtualizado.setIdPessoa(petAtualizar.getIdPessoa());
        petEntityAtualizado.setNome(petAtualizar.getNome());
        petEntityAtualizado.setNome(petAtualizar.getTipo().toString());
        return convertPetDTO(petRepository.save(petEntityAtualizado));
    }

    public void delete(Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        PetEntity petEntity = findByIdPet(id);
        petRepository.delete(petEntity);
    }

    public PetEntity findByIdPet(Integer idPet) throws RegraDeNegocioException {
        PetEntity petEntity = petRepository.findById(idPet)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        return petEntity;
    }
        public PetEntity convertPetEntity (PetCreateDTO petCreateDTO) {
            return objectMapper.convertValue(petCreateDTO, PetEntity.class);
        }
        public PetDTO convertPetDTO (PetEntity petEntity){
            return objectMapper.convertValue(petEntity, PetDTO.class);
        }

}
