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

    private Reuniao reuniao;

    private String titulo;

    @Column(name="DESCRICAO")
    @Lob
    private byte[] descricao;

    @ManyToMany
    @JoinColumn(name="id")
    @Column(name="LISTA_DIRETOR")
    private List<Diretor> diretorList;

    public Notificacao() {
    }

    public Notificacao(Long id, Reuniao reuniao, String titulo, byte[] descricao, List<Diretor> diretorList) {
        this.id = id;
        this.reuniao = reuniao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.diretorList = diretorList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getDescricao() {
        return descricao;
    }

    public void setDescricao(byte[] descricao) {
        this.descricao = descricao;
    }

    public List<Diretor> getDiretorList() {
        return diretorList;
    }

    public void setDiretorList(List<Diretor> diretorList) {
        this.diretorList = diretorList;
    }

}
