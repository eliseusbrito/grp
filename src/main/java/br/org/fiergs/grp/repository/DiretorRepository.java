package br.org.fiergs.grp.repository;

import br.org.fiergs.grp.entity.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface DiretorRepository extends JpaRepository<Diretor, Long> {


    @Transactional
    /*
    @Modifying(clearAutomatically = true)
    @Query(value = "update dda_apims.GRP_DIRETOR dir set situacao = false " +
            "from dda_apims.GRP_DIRETOR where dir.id=?1", nativeQuery = true)
            */
    @Query(value = "update GRP_DIRETOR dir set situacao = false " +
            "from GRP_DIRETOR where dir.id=?1", nativeQuery = true)
    void desativaDiretor(@Param("id") Long id);

}
