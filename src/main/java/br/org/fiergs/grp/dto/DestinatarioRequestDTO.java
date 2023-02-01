package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.entity.Diretor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DestinatarioRequestDTO {

    @NotBlank(message = "destinatario.name.required")
    private String nome;

    @Email(message = "destinatario.email.required")
    private String email;

    private String telefone;

    @NotBlank(message = "destinatario.diretor.required")
    private Diretor diretor;

    public Destinatario transformaParaObjeto(){
        return new Destinatario(nome, email, telefone, diretor);
    }

    public DestinatarioRequestDTO() {
    }

    public DestinatarioRequestDTO(String nome, String email, String telefone, Diretor diretor) {
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
