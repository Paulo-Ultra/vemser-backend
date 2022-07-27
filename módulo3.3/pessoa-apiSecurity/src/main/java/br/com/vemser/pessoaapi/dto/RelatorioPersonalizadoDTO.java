package br.com.vemser.pessoaapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RelatorioPersonalizadoDTO {

    @Schema(description = "Identificador da Pessoa")
    private  Integer idPessoa;
    @Schema(description = "Nome da Pessoa")
    private String nome;
    @Schema(description = "Email da Pessoa")
    private String email;
    @Schema(description = "Número do telefone")
    private String numero;
    @Schema(description = "Cep")
    private String cep;
    @Schema(description = "Cidade")
    private String cidade;
    @Schema(description = "Estado")
    private String estado;
    @Schema(description = "Pais")
    private String pais;
    @Schema(description = "Nome do Pet")
    private String nomePet;
}
