package br.org.fiergs.grp.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Presenca {


    @Entity
    @Table(name="GRP_PRESENCA")
    public class Diretor implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @SequenceGenerator(name = "GRP_DIRETOR_GENERATOR", sequenceName = "GRP_DIRETOR_SEQ", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRP_DIRETOR_GENERATOR")
        @Column(name = "ID")
        private Long id;

    }
}
