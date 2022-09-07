package br.com.dbc.trabalhofinalmodulo2.dto.jogador;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCreateDTO {

    private String nomeJogador;

    private String email;

    private String senha;
}
