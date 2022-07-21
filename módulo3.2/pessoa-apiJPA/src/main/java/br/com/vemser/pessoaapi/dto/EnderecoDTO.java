package br.com.vemser.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    private Integer idEndereco;
}
