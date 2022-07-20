package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PetCreateDTO {
    @Schema(description = "Identificador da Pessoa")
    private Integer idPessoa;

    @NotNull
    @Schema(description = "Tipo do Pet")
    private TipoPet tipo;

    @NotBlank
    @Schema(description = "Nome do Pet")
    private String nome;

}
