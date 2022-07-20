package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Operation(summary = "Lista Pets", description = "Lista todos os pets do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os contatos"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<PetDTO> list (){
        return petService.list();
    }

    @PostMapping
    public ResponseEntity<PetDTO> create(@RequestBody @Valid PetCreateDTO pet) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity<>(petService.create(pet), HttpStatus.CREATED);
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id, @RequestBody @Valid PetCreateDTO petCreateDTO) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity<>(petService.update(petCreateDTO, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity <Void> delete(@PathVariable("idPet") Integer id) throws TemplateException, RegraDeNegocioException, IOException {
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}

