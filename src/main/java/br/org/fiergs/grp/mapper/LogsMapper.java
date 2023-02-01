package br.org.fiergs.grp.mapper;

import br.org.fiergs.grp.entity.Logs;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogsMapper {

    public Logs toModel(Logs logs, String tipo, String tabela, Long idTabela,String detalhamento) {
        logs.setTipo(tipo);
        logs.setTabela(tabela);
        logs.setIdTabela(idTabela);
//        logs.setColunas();
        logs.setDetalhamento(detalhamento);
//        logs.setUsuarioInclusao();
        logs.setDataInclusão(LocalDateTime.now());
        return logs;
    }

}
