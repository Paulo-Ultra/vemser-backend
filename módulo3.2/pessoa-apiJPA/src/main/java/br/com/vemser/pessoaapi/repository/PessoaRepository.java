package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.enums.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    //Query methods
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    List<PessoaEntity> findByCpf(String cpf);


    //jpql - SQL do Java

    @Query("select p" + " from PESSOA p" + " where p.cpf = ?1")
    List<PessoaEntity> listPessoasByCpf(String cpf);

    @Query("select p" + " from PESSOA p" + " where p.cpf = :cpf")
    List<PessoaEntity> listPessoasByCpf2(@Param("cpf")String cpf);

    @Query("select p" +
            " from PESSOA p" +
            " join p.contatos cont" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where cont.tipoContato = :tipoContato")
    List<PessoaEntity> listPessoasPorTipoContato(@Param("tipoContato") String cpf);

    //Querys nativas -> Evitar usar pq não faz conersão de querys de outros bancos
    @Query(name = "select *" +
            " from PESSOA p" +
            " where p.cpf = :cpf",
            nativeQuery = true)
    List<PessoaEntity> listPessoasByCpfNativa(@Param("cpf")String cpf);

    @Query(value = "select *" +
            " from PESSOA p" +
            " join CONTATO cont on (p.id_pessoa = cont.id_pessoa)" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where cont.tipo = :tipoContato",
            nativeQuery = true)
    List<PessoaEntity> listPessoasPorTipoContatoNative(@Param("tipoContato") String cpf);
    }