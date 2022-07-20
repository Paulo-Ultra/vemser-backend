package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class PessoaDTO extends PessoaCreateDTO{
    private Integer idPessoa;

    @Schema(description = "Lista de contatos")
    private List<ContatoDTO> contatoDTOS;

    @Schema(description = "Lista de endereços")
    private List<EnderecoDTO> enderecoDTOS;

    @Schema(description = "Pet")
    private PetDTO petDTO;
}
