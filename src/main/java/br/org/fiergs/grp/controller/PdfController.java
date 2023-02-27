package br.org.fiergs.grp.controller;


import br.org.fiergs.grp.service.PdfService;
import com.itextpdf.text.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class PdfController {

    private PdfService service;

    public PdfController(PdfService service) {
        this.service = service;
    }

    @GetMapping(path = "/pdf")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public void gerarPdf() throws DocumentException, IOException {
        service.gerarPdf();
    }

}
