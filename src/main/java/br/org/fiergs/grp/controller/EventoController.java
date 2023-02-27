package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.dto.DiretorRequestDTO;
import br.org.fiergs.grp.dto.DiretorResponseDTO;
import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Evento;
import br.org.fiergs.grp.service.DiretorService;
import br.org.fiergs.grp.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class EventoController {

    private EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @GetMapping(path = "/eventos")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Evento>> findEventosByReuniao(){
        return ResponseEntity.ok().body(service.findAllEventos());
    }

    @GetMapping(path = "/evento/reuniao/{id}")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Evento>> findEventosByReuniao(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findEventosByReuniao(id));
    }

    @GetMapping(path = "/evento/reuniao/naoidentificados")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<Evento>> findEventosNaoIdentificados(){
        return ResponseEntity.ok().body(service.findEventosNaoIdentificados());
    }

}
