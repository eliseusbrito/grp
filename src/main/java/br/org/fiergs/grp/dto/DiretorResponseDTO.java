package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Destinatario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DiretorResponseDTO {

    private String nome;

    private String email;

    private String telefone;

    private String funcao;

    private String situacao;

    private String organizacao;

    private byte[] foto;

    private List<Destinatario> destinatarioList;

    private LocalDateTime validDateStart;

    private LocalDateTime validDateEnd;

    public static DiretorResponseDTO transformaEmDTO(Diretor diretor) {
        return new DiretorResponseDTO(diretor.getNome(), diretor.getEmail(), diretor.getTelefone(), diretor.getFuncao(), diretor.getSituacao(), diretor.getOrganizacao(), diretor.getFoto(), diretor.getDestinatarioList(), diretor.getValidDateStart(), diretor.getValidDateEnd());
    }

    public DiretorResponseDTO() {
    }

    public DiretorResponseDTO(String nome, String email, String telefone, String funcao, String situacao, String organizacao, byte[] foto, List<Destinatario> destinatarioList, LocalDateTime validDateStart, LocalDateTime validDateEnd) {
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

    public byte[] getFoto() {
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
