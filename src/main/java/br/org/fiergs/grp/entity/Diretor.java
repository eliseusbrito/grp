package br.org.fiergs.grp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="GRP_DIRETOR")
public class Diretor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="GRP_DIRETOR_GENERATOR", sequenceName="GRP_DIRETOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRP_DIRETOR_GENERATOR")
    @Column(name="ID")
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="EMAIL")
    private String email;

    @Column(name="TELEFONE")
    private String telefone;

    @Column(name="FUNCAO")
    private String funcao;

    @Column(name="SITUACAO")
    private String situacao;

    @Column(name="ORGANIZACAO")
    private String organizacao;

    @Column(name="FOTO")
    @Lob
    private byte[] foto;

    @JsonIgnore
    @OneToMany(mappedBy= "diretor")
//    @Column(name="LISTA_DESTINATARIO")
    private List<Destinatario> destinatarioList = new ArrayList<>();

    @Column(name="DATA_INICIO_VIGENCIA")
    private LocalDateTime validDateStart; // ValidDateStart=20151022%20093811

    @Column(name="DATA_FIM_VIGENCIA")
    private LocalDateTime validDateEnd; // ValidDateEnd=20151222%20093811


    public Diretor() {
    }

    public Diretor(String nome, String email, String telefone, String funcao, String situacao, String organizacao, byte[] foto, List<Destinatario> destinatarioList, LocalDateTime validDateStart, LocalDateTime validDateEnd) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.funcao = funcao;
        this.situacao = situacao;
        this.organizacao = organizacao;
        this.foto = foto;
        this.destinatarioList = destinatarioList;
        this.validDateStart = validDateStart;
        this.validDateEnd = validDateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Destinatario> getDestinatarioList() {
        return destinatarioList;
    }

    public void setDestinatarioList(List<Destinatario> destinatarioList) {
        this.destinatarioList = destinatarioList;
    }

    public LocalDateTime getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(LocalDateTime validDateStart) {
        this.validDateStart = validDateStart;
    }

    public LocalDateTime getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(LocalDateTime validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

}
