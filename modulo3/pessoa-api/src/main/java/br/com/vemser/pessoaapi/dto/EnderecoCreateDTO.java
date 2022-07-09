package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoEndereco;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @Length(min = 1, max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotBlank
    @Size(min = 8, max = 8, message = "CEP deve possuir {max} números")
    private String cep;
    @NotBlank
    @Length(max = 250, message = "Campo cidade pode ter no máximo {max} caracteres")
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
