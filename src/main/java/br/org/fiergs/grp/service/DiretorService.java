package br.org.fiergs.grp.service;

import br.org.fiergs.grp.dto.DiretorRequestDTO;
import br.org.fiergs.grp.dto.DiretorResponseDTO;
import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Logs;
import br.org.fiergs.grp.repository.DiretorRepository;
import br.org.fiergs.grp.repository.LogsRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    DiretorRepository repository;

    IntelbrasService intelbrasService;

    LogsService logsService;

    public DiretorService(DiretorRepository repository, @Lazy IntelbrasService intelbrasService, LogsService logsService) {
        this.repository = repository;
        this.intelbrasService = intelbrasService;
        this.logsService = logsService;
    }

    public Diretor cadastroNovoDiretor(DiretorRequestDTO diretorRequestDTO) {
        Diretor diretor = repository.save(diretorRequestDTO.transformaParaObjeto());
        String tipo = "CadastroDiretor";
        String tabela = "GRP_DIRETOR";
        String detalhamento = null;
        Logs logs = logsService.addLog(tipo, tabela, diretor.getId(), detalhamento);
        /*
        if (diretor.getFoto()==null){
            intelbrasService.cadastroDeUsuario();
        } else {
            intelbrasService.addDiretor();
            intelbrasService.addFoto();
        }
*/
        return diretor;
    }

    public List<DiretorResponseDTO> findAll() {
        List<Diretor> diretor = repository.findAll();
        List<DiretorResponseDTO> diretorResponseDTOList = new ArrayList<DiretorResponseDTO>();
        DiretorResponseDTO diretorResponseDTO;
        for (int i = 0; i < diretor.size(); i++) {
            diretorResponseDTO = DiretorResponseDTO.transformaEmDTO(diretor.get(i));
            diretorResponseDTOList.add(diretorResponseDTO);
        }
        return diretorResponseDTOList;
    }

    public Optional<Diretor> findDiretorById(Long id){
        return repository.findById(id);
    }

    public Diretor updateDiretor(Long id, DiretorRequestDTO diretorRequestDTO) {
        Diretor diretor = repository.getReferenceById(id);
        diretor.setNome(diretorRequestDTO.getNome());
        diretor.setEmail(diretorRequestDTO.getEmail());
        diretor.setTelefone(diretorRequestDTO.getTelefone());
        diretor.setSituacao(diretorRequestDTO.getSituacao());
        diretor.setOrganizacao(diretorRequestDTO.getOrganizacao());
        diretor.setFoto(diretorRequestDTO.getFoto());
        diretor.setDestinatarioList(diretorRequestDTO.getDestinatarioList());
        diretor.setValidDateStart(diretorRequestDTO.getValidDateStart());
        diretor.setValidDateEnd(diretorRequestDTO.getValidDateEnd());

        String tipo = "UpdateDiretor";
        String tabela = "GRP_DIRETOR";
        String detalhamento = null;
        Logs logs = logsService.addLog(tipo, tabela, diretor.getId(), detalhamento);
        return diretor;
    }


}
