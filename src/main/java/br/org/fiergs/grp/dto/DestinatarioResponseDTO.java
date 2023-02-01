package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.entity.Diretor;

public class DestinatarioResponseDTO {

    private String nome;

    private String email;

    private String telefone;

    private Diretor diretor;

    public static DestinatarioResponseDTO transformaEmDTO(Destinatario destinatario) {
        return new DestinatarioResponseDTO(destinatario.getNome(), destinatario.getEmail(), destinatario.getTelefone(), destinatario.getDiretor());
    }

    public DestinatarioResponseDTO() {
    }

    public DestinatarioResponseDTO(String nome, String email, String telefone, Diretor diretor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.diretor = diretor;
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
