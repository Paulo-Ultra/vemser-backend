package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotBlank
    @Size(min = 1, max = 13, message = "Número pode ter até {max} números")
    private String numero;
    @NotBlank
    private String descricao;
}
