package br.org.fiergs.grp.controller;

import br.org.fiergs.grp.entity.Face;
import br.org.fiergs.grp.service.IntelbrasService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class IntelbrasController {

    private IntelbrasService service;

    public IntelbrasController(IntelbrasService service) {
        this.service = service;
    }

    @GetMapping(path = "/getFirmware")
    //    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public String getFirmware() {
        return service.getFirmware();
    }

    @GetMapping(path = "/allUsers")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public String obterTodosUsuarios() {
        return service.obterTodosUsuarios();
    }

    @GetMapping(path = "/cadastroUsuario/{diretorId}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public String cadastroUsuario(@PathVariable Long diretorId) throws ParseException {
        return service.cadastroUsuario(diretorId);
    }


    //cadastroFotoUsuario
    @GetMapping(path = "/cadastroFotoUsuario")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public String cadastrarFotoUsuario(@RequestBody List<Face> faceList) throws UnsupportedEncodingException {
        return service.cadastroFotoUsuario(faceList);
    }


    //obterRegistroAcessos
    //precisa passar data e ou hora de inicio e fim
    @GetMapping(path = "/registrosAcesso/{timestampInicio}/{timestampFinal}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public String registrosAcessos(@PathVariable String timestampInicio, @PathVariable String timestampFinal) throws UnsupportedEncodingException {
        return service.registrosAcesso(timestampInicio, timestampFinal);
    }

    //imagemRegistroEvento
    //eventos listados acima
    @GetMapping(path = "/imagemAcesso/{fileName}")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public void imagemAcesso(@RequestParam String fileName) throws IOException {
        service.imagemAcesso(fileName);
    }

}
