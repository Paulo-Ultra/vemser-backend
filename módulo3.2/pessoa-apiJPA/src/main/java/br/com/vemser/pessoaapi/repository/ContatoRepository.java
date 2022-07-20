package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.enums.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("select c" +
            " from CONTATO c" +
            " where c.tipoContato = :tipoContato")
    List<ContatoEntity> listContatoPorTipoContato(@Param("tipoContato") TipoContato tipoContato);

    @Query(value = "select c" +
            " from CONTATO c" +
            " where c.tipo = :tipoContato",
            nativeQuery = true)
    List<ContatoEntity> listContatoPorTipoContatoNative(@Param("tipoContato") TipoContato tipoContato);
}
