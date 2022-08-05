package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public List<ProfessorEntity> findAll(){
        return professorRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public ProfessorEntity save(ProfessorEntity professor) {
       return professorRepository.save(professor);
    }
}
