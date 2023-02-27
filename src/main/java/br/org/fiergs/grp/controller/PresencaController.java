package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.entity.Presenca;
import br.org.fiergs.grp.service.PresencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class PresencaController {

    private PresencaService presencaService;

    public PresencaController(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    @GetMapping(path = "/presenca/reuniao/{reuniaoId}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Presenca>> findByReuniaoId(@PathVariable("reuniaoId") Long reuniaoId) {
        return ResponseEntity.ok().body(presencaService.findByReuniaoId(reuniaoId));
    }

    @GetMapping(path = "/presenca/diretor/{diretorId}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Presenca>> findByDiretorId(@PathVariable("diretorId") Long diretorId) {
        return ResponseEntity.ok().body(presencaService.findByDiretorId(diretorId));
    }

    @PutMapping(path = "/presenca/grava/{reuniaoId}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Presenca>> gravaPresenca(@PathVariable("reuniaoId") Long reuniaoId) throws IOException {
        return ResponseEntity.ok().body(presencaService.gravaPresenca(reuniaoId));
    }

}