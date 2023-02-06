package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.DiretoresReunioes;
import br.org.fiergs.grp.repository.DiretoresReunioesRepository;
import org.springframework.stereotype.Service;

@Service
public class DiretoresReunioesService {

    DiretoresReunioesRepository repository;

    public DiretoresReunioesService(DiretoresReunioesRepository repository) {
        this.repository = repository;
    }

    public void addConvites(Long idReuniao, Long idDiretor) {

        repository.addConvites(idReuniao, idDiretor);

//        Logs logs = logsService.addLog(tipo, tabela, reuniao.getId(), detalhamento);
    }

}
