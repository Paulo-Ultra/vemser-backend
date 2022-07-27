package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.enums.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("select ep" +
            " from ENDERECO_PESSOA ep" +
            " join ep.pessoas p" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where p.idPessoa = :idPessoa")
    List<EnderecoEntity> listEnderecosPeloCep(@Param("idPessoa") Integer idPessoa);

    @Query(value = "select ep" +
            " from ENDERECO_PESSOA ep" +
            " join ep.pessoas p" + //=== " join CONTATO cont on (p.id_pessoa = c.id_pessoa)"
            " where p.idPessoa = :idPessoa",
            nativeQuery = true)
    List<EnderecoEntity> listEnderecosPorIdPessoaNative(@Param("idPessoa") Integer idPessoa);

    @Query("select ep" +
            " from ENDERECO_PESSOA ep")
    Page<EnderecoEntity> listEnderecoPeloCep(@Param("cep") String cep, Pageable pageable);

    @Query("select ep" +
            " from ENDERECO_PESSOA ep" +
            " where (:pais is null OR ep.pais = :pais)")
    Page<EnderecoEntity> listEnderecoPeloPais(@Param("pais") String pais, Pageable pageable);
}


