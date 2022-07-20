package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
