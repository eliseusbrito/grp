package br.org.fiergs.grp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="GRP_LOGS")
public class Logs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="GRP_LOGS_GENERATOR", sequenceName="GRP_LOGS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRP_LOGS_GENERATOR")
    @Column(name="ID")
    private Long id;

    private String tipo;

    private String tabela;

    private Long idTabela;

    private String colunas;

    private String detalhamento;

//Diretor

    private String usuarioInclusao;
    private LocalDateTime dataInclusão;


//Tipo enum edicaoEditor


    public Logs() {
    }

    public Logs(Long id, String tipo, String tabela, Long idTabela, String colunas, String detalhamento, String usuarioInclusao, LocalDateTime dataInclusão) {
        this.id = id;
        this.tipo = tipo;
        this.tabela = tabela;
        this.idTabela = idTabela;
        this.colunas = colunas;
        this.detalhamento = detalhamento;
        this.usuarioInclusao = usuarioInclusao;
        this.dataInclusão = dataInclusão;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTabela() {
        return tabela;
    }

    public Long getIdTabela() {
        return idTabela;
    }

    public String getColunas() {
        return colunas;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public String getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public LocalDateTime getDataInclusão() {
        return dataInclusão;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public void setIdTabela(Long idTabela) {
        this.idTabela = idTabela;
    }

    public void setColunas(String colunas) {
        this.colunas = colunas;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public void setUsuarioInclusao(String usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public void setDataInclusão(LocalDateTime dataInclusão) {
        this.dataInclusão = dataInclusão;
    }
}
