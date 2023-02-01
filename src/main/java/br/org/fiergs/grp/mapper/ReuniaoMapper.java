package br.org.fiergs.grp.mapper;

import br.org.fiergs.grp.dto.ReuniaoRequestDTO;
import br.org.fiergs.grp.dto.ReuniaoResponseDTO;
import br.org.fiergs.grp.entity.Reuniao;
import org.springframework.stereotype.Component;

@Component
public class ReuniaoMapper {

    public Reuniao toModel(Reuniao reuniao, ReuniaoRequestDTO reuniaoRequestDTO) {
        reuniao.setAssunto(reuniaoRequestDTO.getAssunto());
        reuniao.setFullDate(reuniaoRequestDTO.getFullDate());
        reuniao.setLocal(reuniaoRequestDTO.getLocal());
        reuniao.setTipoReuniao(reuniaoRequestDTO.getTipoReuniao());
        reuniao.setStatus(reuniaoRequestDTO.getStatus());
        reuniao.setDiretorList(reuniaoRequestDTO.getDiretorList());
        return reuniao;
    }

    public ReuniaoResponseDTO toDTO(ReuniaoResponseDTO reuniaoResponseDTO, Reuniao reuniao) {
        reuniaoResponseDTO.setAssunto(reuniao.getAssunto());
        reuniaoResponseDTO.setFullDate(reuniao.getFullDate());
        reuniaoResponseDTO.setLocal(reuniao.getLocal());
        reuniaoResponseDTO.setTipoReuniao(reuniao.getTipoReuniao());
        reuniaoResponseDTO.setStatus(reuniao.getStatus());
        reuniaoResponseDTO.setDiretorList(reuniao.getDiretorList());
        return reuniaoResponseDTO;
    }

}
