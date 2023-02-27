package br.org.fiergs.grp.repository;

import br.org.fiergs.grp.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {


    //    @Query(value = "SELECT * FROM GRP_EVENTO where USER_ID IS not NULL and reuniao_id=?1", nativeQuery = true)
    @Query("select ev from Evento ev where ev.reuniao.id = :reuniao_id")
    List<Evento> findEventosByReuniao(@Param("reuniao_id") Long reuniao_id);

    @Query(value = "SELECT * FROM GRP_EVENTO where USER_ID IS NULL", nativeQuery = true)
    List<Evento> findEventosNaoIdentificados();


}
