package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.entity.Diretor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class DestinatarioRequestDTO {

    @NotBlank(message = "destinatario.name.required")
    private String nome;

    @Email(message = "destinatario.email.required")
    private String email;

    private String telefone;

    @NotBlank(message = "destinatario.diretor.required")
    private Long idDiretor;

    public Destinatario transformaParaObjeto(DestinatarioRequestDTO destinatarioRequestDTO, Optional<Diretor> diretor){
        return new Destinatario(nome, email, telefone, diretor.orElseThrow());
    }

    public DestinatarioRequestDTO() {
    }

    public DestinatarioRequestDTO(String nome, String email, String telefone, Long idDiretor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idDiretor = idDiretor;
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

    public Long getIdDiretor() {
        return idDiretor;
    }

}
