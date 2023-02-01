package br.org.fiergs.grp.dto;

import br.org.fiergs.grp.entity.Diretor;

import java.time.LocalDateTime;
import java.util.List;

public class ReuniaoResponseDTO {

    private String assunto;

    private LocalDateTime fullDate;

    private String local;

    private String tipoReuniao;

    private String status;

    private List<Diretor> diretorList;

    public ReuniaoResponseDTO() {
    }

    public ReuniaoResponseDTO(String assunto, LocalDateTime fullDate, String local, String tipoReuniao, String status, List<Diretor> diretorList) {
        this.assunto = assunto;
        this.fullDate = fullDate;
        this.local = local;
        this.tipoReuniao = tipoReuniao;
        this.status = status;
        this.diretorList = diretorList;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDateTime getFullDate() {
        return fullDate;
    }

    public void setFullDate(LocalDateTime fullDate) {
        this.fullDate = fullDate;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(String tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Diretor> getDiretorList() {
        return diretorList;
    }

    public void setDiretorList(List<Diretor> diretorList) {
        this.diretorList = diretorList;
    }
}
