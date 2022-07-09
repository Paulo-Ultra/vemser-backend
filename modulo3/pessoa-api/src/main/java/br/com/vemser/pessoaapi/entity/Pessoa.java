package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private Integer idPessoa;
    @NotBlank(message = "Insira um nome!" )
    //Para evitar que o atributo tenha o getter por exemplo
//    @Getter(AccessLevel.NONE)
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotEmpty
    @Size(min = 11, max = 11, message = "CPF deve conter {max} números")
    private String cpf;
}
