package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import br.com.vemser.pessoaapi.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> list() {
        return new ResponseEntity<>(professorService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> create(@RequestBody ProfessorEntity professor) {
        return new ResponseEntity<>(professorService.save(professor), HttpStatus.CREATED);
    }
}
