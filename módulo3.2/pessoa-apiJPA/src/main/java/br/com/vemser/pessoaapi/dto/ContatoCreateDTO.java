package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotNull
    @Schema(description = "Tpo de ContatoEntity")
    private TipoContato tipoContato;
    @NotBlank
    @Size(min = 1, max = 13, message = "Número pode ter até {max} números")
    @Schema(description = "Número do Telefone")
    private String numero;
    @NotBlank
    @Schema(description = "Descrição do Telefone")
    private String descricao;
}
