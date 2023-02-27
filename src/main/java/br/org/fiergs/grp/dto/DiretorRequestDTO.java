package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.entity.Diretor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class DiretorRequestDTO {

    @NotBlank(message = "diretor.name.required")
    private String nome;

    @Email(message = "diretor.email.required")
    private String email;

    private String telefone;

    private String funcao;

    private String situacao;

    private String organizacao;

    private String foto;

    private List<Destinatario> destinatarioList;

    private LocalDateTime validDateStart;

    private LocalDateTime validDateEnd;

    public Diretor transformaParaObjeto(){
        return new Diretor(nome, email, telefone, funcao, situacao, organizacao, foto, destinatarioList, validDateStart, validDateEnd);
    }

    public DiretorRequestDTO() {
    }

    public DiretorRequestDTO(String nome, String email, String telefone, String funcao, String situacao, String organizacao, String foto, List<Destinatario> destinatarioList, LocalDateTime validDateStart, LocalDateTime validDateEnd) {
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

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public String getFoto() {
        return foto;
    }

    public List<Destinatario> getDestinatarioList() {
        return destinatarioList;
    }

    public LocalDateTime getValidDateStart() {
        return validDateStart;
    }

    public LocalDateTime getValidDateEnd() {
        return validDateEnd;
    }

}
