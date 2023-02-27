package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Evento;
import br.org.fiergs.grp.entity.Presenca;
import br.org.fiergs.grp.entity.Reuniao;
import br.org.fiergs.grp.repository.PresencaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class PresencaService {

    public PresencaRepository repository;

    LogsService logsService;

    EventoService eventoService;

    IntelbrasService intelbrasService;

    public PresencaService(PresencaRepository repository, LogsService logsService, EventoService eventoService,@Lazy IntelbrasService intelbrasService) {
        this.repository = repository;
        this.logsService = logsService;
        this.eventoService = eventoService;
        this.intelbrasService = intelbrasService;
    }

    public Presenca addReuniaoAndDiretor(Reuniao reuniao, Diretor diretor) {
        Presenca presenca = new Presenca();
        presenca.setReuniao(reuniao);
        presenca.setDiretor(diretor);
        repository.save(presenca);
        String tipo = "CadastroPresenca";
        String tabela = "GRP_PRESENCA";
        String detalhamento = "Incluido na  Reunião  id: " + reuniao.getId() + "  assunto: " + reuniao.getAssunto() + "  o  Diretor id: " + diretor.getId() + "  nome: " + diretor.getNome();
        logsService.addLog(tipo, tabela, reuniao.getId(), detalhamento);
        return presenca;
    }

    public List<Presenca> findPresencaByReuniaoId(Long id) {
        return repository.findByReuniaoId(id);
    }

    public void deletaDiretoresdaReuniao(Reuniao reuniao) {
        repository.deletaDiretoresDaReuniao(reuniao.getId());
        String tipo = "DelecaoPresenca";
        String tabela = "GRP_PRESENCA";
        String detalhamento = "Deletado os integrantes da  Reunião  id: " + reuniao.getId() + "  assunto: " + reuniao.getAssunto();
        logsService.addLog(tipo, tabela, reuniao.getId(), detalhamento);
    }

    public List<Presenca> findByReuniaoId(Long reuniaoId) {
        return repository.findByReuniaoId(reuniaoId);
    }

    public List<Presenca> findByDiretorId(Long diretorId) {
        return repository.findByDiretorId(diretorId);
    }


    public List<Presenca> gravaPresenca(Long reuniaoId) throws IOException {

        List<Evento> eventoList = eventoService.findEventosByReuniao(reuniaoId);
        for (int i = 0; i <= eventoList.size(); i++) {
            repository.gravaPresenca(reuniaoId, parseLong(eventoList.get(i).getUserId()));
            /*
            String link = eventoList.get(i).getLink();
//            String fotoBase64 = intelbrasService.imagemAcesso(link);
            String fotoBase64 = "/9j/4QvGaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49J++7vycgaWQ9J1c1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCc/Pg";
            repository.gravaFoto(reuniaoId, parseLong(eventoList.get(i).getUserId()), fotoBase64);
             */
        }


        return repository.findByReuniaoId(reuniaoId);
    }

}
