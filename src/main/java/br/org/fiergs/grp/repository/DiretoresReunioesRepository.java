package br.org.fiergs.grp.repository;

import br.org.fiergs.grp.entity.DiretoresReunioes;
import br.org.fiergs.grp.entity.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DiretoresReunioesRepository extends JpaRepository<DiretoresReunioes, Long> {


    @Transactional
    @Modifying
    @Query(value = "insert into DIRETORES_REUNIOES (reuniao_id, diretor_id) VALUES (?1, ?2)", nativeQuery = true)
    void addConvites(@Param("idReuniao") Long idReuniao, @Param("idDiretor") Long idDiretor);

/*
    @Transactional
    @Modifying
    @Query("update Presenca set presente = true where idReuniao =:reuniao_id and idDiretor = : idDiretor")
    void addPresenca(@Param("idReuniao") Long idReuniao, @Param("idDiretor") Long idDiretor);
*/
}
