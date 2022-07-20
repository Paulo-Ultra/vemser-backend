package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select ep" +
            " from ENDERECO_PESSOA ep" +
            " join ep.pessoas p" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where p.idPessoa = :idPessoa")
    List<EnderecoEntity> listEnderecosPorIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query(value = "select ep" +
            " from ENDERECO_PESSOA ep" +
            " join ep.pessoas p" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where p.idPessoa = :idPessoa",
            nativeQuery = true)
    List<EnderecoEntity> listEnderecosPorIdPessoaNative(@Param("idPessoa") Integer idPessoa);
}
