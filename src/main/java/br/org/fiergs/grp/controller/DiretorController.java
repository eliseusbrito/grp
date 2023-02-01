package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.dto.DiretorRequestDTO;
import br.org.fiergs.grp.dto.DiretorResponseDTO;
import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.service.DiretorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(DiretorService service) {
        this.diretorService = service;
    }

    @PostMapping(path = "/diretor")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<DiretorResponseDTO> cadastroNovoDiretor(@RequestBody @Valid DiretorRequestDTO diretorRequestDTO) {
        Diretor diretor = diretorService.cadastroNovoDiretor(diretorRequestDTO);
        DiretorResponseDTO diretorResponseDTO = new DiretorResponseDTO();
        return ResponseEntity.ok().body(diretorResponseDTO.transformaEmDTO(diretor));
    }

    @GetMapping(path = "/diretores")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<List<DiretorResponseDTO>> findAll() {
        return ResponseEntity.ok().body(diretorService.findAll());
    }

    @GetMapping(path = "/diretor/{id}")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public ResponseEntity<DiretorResponseDTO> findDiretorById(@PathVariable Long id){
        Optional<Diretor> diretor = diretorService.findDiretorById(id);
        DiretorResponseDTO diretorResponseDTO = new DiretorResponseDTO();
        return ResponseEntity.ok().body(diretorResponseDTO.transformaEmDTO(diretor.orElseThrow()));
    }

    @PutMapping(path = "/diretor/{id}")
    public ResponseEntity<DiretorResponseDTO> updateDiretor(@PathVariable Long id, @RequestBody @Valid DiretorRequestDTO diretorRequestDTO) {
        Diretor diretor = diretorService.updateDiretor(id, diretorRequestDTO);
        DiretorResponseDTO diretorResponseDTO = new DiretorResponseDTO();
        return ResponseEntity.ok().body(diretorResponseDTO.transformaEmDTO(diretor));
    }


}
