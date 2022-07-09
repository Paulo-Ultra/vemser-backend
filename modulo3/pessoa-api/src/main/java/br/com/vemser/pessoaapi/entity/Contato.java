package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoContato;
import lombok.*;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotBlank
    @Size(min = 1, max = 13, message = "Número pode ter até {max} números")
    private String numero;
    @NotBlank
    private String descricao;
}
