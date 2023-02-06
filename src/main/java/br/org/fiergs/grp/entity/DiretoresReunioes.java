package br.org.fiergs.grp.entity;

import javax.persistence.*;

@Entity
@Table(name = "DIRETORES_REUNIOES")
public class DiretoresReunioes {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="GRP_DIRETORES_REUNIOES_GENERATOR", sequenceName="GRP_DIRETORES_REUNIOES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRP_DIRETORES_REUNIOES_GENERATOR")
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    @ManyToOne
    @JoinColumn(name = "reuniao_id")
    private Reuniao reuniao;

    @Column(name = "presente")
    private double presente;

    @Column(name = "detalhamento")
    private String detalhamento;

    public DiretoresReunioes() {
    }

    public DiretoresReunioes(Long id, Diretor diretor, Reuniao reuniao, double presente, String detalhamento) {
        this.id = id;
        this.diretor = diretor;
        this.reuniao = reuniao;
        this.presente = presente;
        this.detalhamento = detalhamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    public double getPresente() {
        return presente;
    }

    public void setPresente(double presente) {
        this.presente = presente;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }
}
