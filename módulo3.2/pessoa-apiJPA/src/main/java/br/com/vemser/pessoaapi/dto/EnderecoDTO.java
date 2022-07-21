package br.com.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    private Integer idEndereco;
    @NotNull
    private Integer idPessoa;
}
