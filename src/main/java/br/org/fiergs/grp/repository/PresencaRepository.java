package br.org.fiergs.grp.repository;

import br.org.fiergs.grp.entity.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PresencaRepository extends JpaRepository<Presenca, Long> {

    List<Presenca> findByReuniaoId(Long reuniaoId);

    List<Presenca> findByDiretorId(Long diretorId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM GRP_PRESENCA WHERE reuniao_id = ?1", nativeQuery = true)
    void deletaDiretoresDaReuniao(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update GRP_PRESENCA set presente = true where reuniao_id=?1 and diretor_id =?2", nativeQuery = true)
    void gravaPresenca(@Param("idReuniao") Long idReuniao, @Param("id") Long idDiretor);

    @Transactional
    @Modifying
    @Query(value = "update GRP_PRESENCA set foto = ?3 where reuniao_id=?1 and diretor_id =?2", nativeQuery = true)
    void gravaFoto(@Param("idReuniao") Long idReuniao, @Param("id") Long idDiretor, @Param("fotoBase64") String fotoBase64);


}
