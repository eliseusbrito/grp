package br.org.fiergs.grp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "GRP_NOTIFICACAO")
public class Notificacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "GRP_NOTIFICACAO_GENERATOR", sequenceName = "GRP_NOTIFICACAO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRP_NOTIFICACAO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO", length = 4000)
    @Lob
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "reuniao_id")
    private Reuniao reuniao;

    public Notificacao() {
    }

    public Notificacao(String titulo, String descricao, Reuniao reuniao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.reuniao = reuniao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

}
