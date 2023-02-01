package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.dto.DestinatarioRequestDTO;
import br.org.fiergs.grp.dto.DestinatarioResponseDTO;
import br.org.fiergs.grp.entity.Destinatario;
import br.org.fiergs.grp.service.DestinatarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class DestinatarioController {

    private DestinatarioService destinatarioService;

    public DestinatarioController(DestinatarioService service) {
        this.destinatarioService = service;
    }

    @PostMapping(path = "/destinatario")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<DestinatarioResponseDTO> addDestinatario(@RequestBody @Valid DestinatarioRequestDTO destinatarioRequestDTO) {
        Destinatario destinatario = destinatarioService.addDestinatario(destinatarioRequestDTO);
        DestinatarioResponseDTO destinatarioResponseDTO = new DestinatarioResponseDTO();
        return ResponseEntity.ok().body(destinatarioResponseDTO.transformaEmDTO(destinatario));
    }

    @GetMapping(path = "/destinatarios")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<DestinatarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(destinatarioService.findAll());
    }

    @DeleteMapping(path = "/destinatario/{id}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        destinatarioService.delete(id);
        return ResponseEntity.ok().build();
    }


}
