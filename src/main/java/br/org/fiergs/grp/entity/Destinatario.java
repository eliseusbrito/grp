package br.org.fiergs.grp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="GRP_DESTINATARIO")
public class Destinatario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="GRP_DESTINATARIO_GENERATOR", sequenceName="GRP_DESTINATARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRP_DESTINATARIO_GENERATOR")
    @Column(name="ID")
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="EMAIL")
    private String email;

    @Column(name="TELEFONE")
    private String telefone;

    @ManyToOne
    @JoinColumn(name="diretor_id")
    private Diretor diretor;

    public Destinatario() {
    }

    public Destinatario(String nome, String email, String telefone, Diretor diretor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Diretor getDiretor() {
        return diretor;
    }
}
