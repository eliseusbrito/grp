package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.Logs;
import br.org.fiergs.grp.mapper.LogsMapper;
import br.org.fiergs.grp.repository.LogsRepository;
import org.springframework.stereotype.Service;

@Service
public class LogsService {

    public LogsRepository repository;

    public final LogsMapper logsMapper;

    public LogsService(LogsRepository repository, LogsMapper logsMapper) {
        this.repository = repository;
        this.logsMapper = logsMapper;
    }

    public Logs addLog(String tipo, String tabela, Long idTabela, String detalhamento) {
        Logs logs = new Logs();
        logsMapper.toModel(logs, tipo, tabela, idTabela, detalhamento);
        return repository.save(logs);
    }


}
