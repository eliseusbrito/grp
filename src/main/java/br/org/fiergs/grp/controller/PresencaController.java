package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.dto.ReuniaoRequestDTO;
import br.org.fiergs.grp.dto.ReuniaoResponseDTO;
import br.org.fiergs.grp.entity.Presenca;
import br.org.fiergs.grp.entity.Reuniao;
import br.org.fiergs.grp.mapper.ReuniaoMapper;
import br.org.fiergs.grp.service.PresencaService;
import br.org.fiergs.grp.service.ReuniaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class PresencaController {
/*
    private PresencaService service;

    ReuniaoService reuniaoService;

    public PresencaController(PresencaService service) {
        this.service = service;
    }

    @PostMapping(value = "/presenca")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<Optional<Reuniao>> addPresenca(@PathVariable Long idReuniao, @PathVariable Long idDiretor) {
       service.addPresenca(idReuniao, idDiretor);
       Optional<Reuniao> reuniao = reuniaoService.findReuniaoById(idReuniao);
        return ResponseEntity.ok().body(reuniao);
    }

*/
}
