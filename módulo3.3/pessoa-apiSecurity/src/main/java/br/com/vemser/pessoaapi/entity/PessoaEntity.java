package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//Usar Sempre Getter e Setter e não @Data pode causar erro no Spring
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET", referencedColumnName = "ID_PET")
    private PetEntity pet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
                joinColumns = @JoinColumn(name="id_pessoa"),
                inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private Set<EnderecoEntity> enderecos;
}
