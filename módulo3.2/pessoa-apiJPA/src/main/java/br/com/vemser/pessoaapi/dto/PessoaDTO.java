package br.com.vemser.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class PessoaDTO extends PessoaCreateDTO{
    private Integer idPessoa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Lista de contatos")
    private List<ContatoDTO> contatoDTOS;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Lista de endereços")
    private List<EnderecoDTO> enderecoDTOS;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Pet")
    private PetDTO petDTO;
}
