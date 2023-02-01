package br.org.fiergs.grp.service;

import br.org.fiergs.grp.dto.DestinatarioRequestDTO;
import br.org.fiergs.grp.dto.DestinatarioResponseDTO;
import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.entity.Logs;
import br.org.fiergs.grp.exceptions.ResourceNotFoundException;
import br.org.fiergs.grp.repository.DestinatarioRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinatarioService {

    DestinatarioRepository repository;

    LogsService logsService;

    public DestinatarioService(DestinatarioRepository repository, LogsService logsService) {
        this.repository = repository;
        this.logsService = logsService;
    }

    public Destinatario addDestinatario(DestinatarioRequestDTO destinatarioRequestDTO) {
        return repository.save(destinatarioRequestDTO.transformaParaObjeto());
    }

    public List<DestinatarioResponseDTO> findAll() {
        List<Destinatario> destinatario = repository.findAll();
        List<DestinatarioResponseDTO> destinatarioResponseDTOList = new ArrayList<DestinatarioResponseDTO>();
        DestinatarioResponseDTO destinatarioResponseDTO;
        for (int i = 0; i < destinatario.size(); i++) {
            destinatarioResponseDTO = DestinatarioResponseDTO.transformaEmDTO(destinatario.get(i));
            destinatarioResponseDTOList.add(destinatarioResponseDTO);
        }
        return destinatarioResponseDTOList;
    }

    public void delete(Long id) {
        Destinatario destinatario = repository.getReferenceById(id);
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        String tipo = "DeleteDestinatario";
        String tabela = "GRP_DESTINATARIO";
        String detalhamento = "Deletado " + destinatario.getNome();
        Logs logs = logsService.addLog(tipo, tabela, destinatario.getId(), detalhamento);
    }

}
