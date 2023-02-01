package br.org.fiergs.grp.service;

import br.org.fiergs.grp.dto.DiretorRequestDTO;
import br.org.fiergs.grp.dto.ReuniaoRequestDTO;
import br.org.fiergs.grp.dto.ReuniaoResponseDTO;
import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Logs;
import br.org.fiergs.grp.entity.Reuniao;
import br.org.fiergs.grp.mapper.ReuniaoMapper;
import br.org.fiergs.grp.repository.ReuniaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReuniaoService {

    public ReuniaoRepository repository;

    public ReuniaoMapper reuniaoMapper;

    LogsService logsService;

    public ReuniaoService(ReuniaoRepository repository, ReuniaoMapper reuniaoMapper, LogsService logsService) {
        this.repository = repository;
        this.reuniaoMapper = reuniaoMapper;
        this.logsService = logsService;
    }

    public Reuniao addReuniao(ReuniaoRequestDTO reuniaoRequestDTO) {
        Reuniao reuniao = new Reuniao();
        repository.save(reuniaoMapper.toModel(reuniao, reuniaoRequestDTO));
        String tipo = "CadastroReuniao";
        String tabela = "GRP_REUNIAO";
        String detalhamento = null;
        Logs logs = logsService.addLog(tipo, tabela, reuniao.getId(), detalhamento);
        return reuniao;
    }

    public List<ReuniaoResponseDTO> findAll() {
        List<Reuniao> reuniao = repository.findAll();
        List<ReuniaoResponseDTO> reuniaoResponseDTOList = new ArrayList<>();
        ReuniaoResponseDTO reuniaoResponseDTO = new ReuniaoResponseDTO();
        for (int i = 0; i < reuniao.size(); i++) {
            reuniaoResponseDTO = reuniaoMapper.toDTO(reuniaoResponseDTO, reuniao.get(i));
            reuniaoResponseDTOList.add(reuniaoResponseDTO);
        }
        return reuniaoResponseDTOList;
    }

    public Optional<Reuniao> findReuniaoById(Long id) {
        return repository.findById(id);
    }

    public Reuniao updateReuniao(Long id, ReuniaoRequestDTO reuniaoRequestDTO) {
        Reuniao reuniao = repository.getReferenceById(id);
        reuniao.setAssunto(reuniaoRequestDTO.getAssunto());
        reuniao.setFullDate(reuniaoRequestDTO.getFullDate());
        reuniao.setLocal(reuniaoRequestDTO.getLocal());
        reuniao.setTipoReuniao(reuniaoRequestDTO.getTipoReuniao());
        reuniao.setStatus(reuniaoRequestDTO.getStatus());
        reuniao.setDiretorList(reuniaoRequestDTO.getDiretorList());

        String tipo = "UpdateReuniao";
        String tabela = "GRP_REUNIAO";
        String detalhamento = null;
        Logs logs = logsService.addLog(tipo, tabela, reuniao.getId(), detalhamento);
        return reuniao;
    }

}
