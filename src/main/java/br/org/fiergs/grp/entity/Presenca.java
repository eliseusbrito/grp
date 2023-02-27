package br.org.fiergs.grp.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Embeddable
@Entity
@Table(name = "GRP_PRESENCA")
public class Presenca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="GRP_PRESENCA_GENERATOR", sequenceName="GRP_PRESENCA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRP_PRESENCA_GENERATOR")
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reuniao_id")
    private Reuniao reuniao;

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    @Column(name = "INTENCAO")
    private String intencao;

    @Column(name = "PRESENTE")
    private Boolean presente;

    @Column(name = "FOTO")
    @Lob
    private byte[] foto;

    public Presenca() {
    }

    public Presenca(Reuniao reuniao, Diretor diretor, String intencao, Boolean presente, byte[] foto) {
        this.reuniao = reuniao;
        this.diretor = diretor;
        this.intencao = intencao;
        this.presente = presente;
        this.foto = foto;
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

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getIntencao() {
        return intencao;
    }

    public void setIntencao(String intencao) {
        this.intencao = intencao;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
