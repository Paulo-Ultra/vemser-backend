package br.com.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    @NotNull
    private Integer idEndereco;
}
