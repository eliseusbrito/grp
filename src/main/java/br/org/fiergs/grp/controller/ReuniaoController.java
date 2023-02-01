package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.dto.*;
import br.org.fiergs.grp.dto.ReuniaoRequestDTO;
import br.org.fiergs.grp.dto.ReuniaoResponseDTO;
import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Logs;
import br.org.fiergs.grp.entity.Reuniao;
import br.org.fiergs.grp.entity.Reuniao;
import br.org.fiergs.grp.mapper.ReuniaoMapper;
import br.org.fiergs.grp.service.ReuniaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class ReuniaoController {

    private ReuniaoService reuniaoService;

    private ReuniaoMapper reuniaoMapper;

    public ReuniaoController(ReuniaoService reuniaoService, ReuniaoMapper reuniaoMapper) {
        this.reuniaoService = reuniaoService;
        this.reuniaoMapper = reuniaoMapper;
    }

    @PostMapping(value = "/reuniao")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<ReuniaoResponseDTO> addReuniao(@RequestBody ReuniaoRequestDTO reuniaoRequestDTO) {
        Reuniao reuniao = reuniaoService.addReuniao(reuniaoRequestDTO);
        ReuniaoResponseDTO reuniaoResponseDTO = new ReuniaoResponseDTO();
        return ResponseEntity.ok().body(reuniaoMapper.toDTO(reuniaoResponseDTO, reuniao));
    }

    @GetMapping(path = "/reunioes")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<ReuniaoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(reuniaoService.findAll());
    }

    @GetMapping(path = "/reuniao/{id}")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<ReuniaoResponseDTO> findReuniaoById(@PathVariable Long id){
        Optional<Reuniao> reuniao = reuniaoService.findReuniaoById(id);
        ReuniaoResponseDTO reuniaoResponseDTO = new ReuniaoResponseDTO();
        return ResponseEntity.ok().body(reuniaoMapper.toDTO(reuniaoResponseDTO, reuniao.orElseThrow()));
    }

    @PutMapping(path = "/reuniao/{id}")
    public ResponseEntity<ReuniaoResponseDTO> updateReuniao(@PathVariable Long id, @RequestBody @Valid ReuniaoRequestDTO reuniaoRequestDTO) {
        Reuniao reuniao = reuniaoService.updateReuniao(id, reuniaoRequestDTO);
        ReuniaoResponseDTO reuniaoResponseDTO = new ReuniaoResponseDTO();
        return ResponseEntity.ok().body(reuniaoMapper.toDTO(reuniaoResponseDTO, reuniao));
    }

}
