package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.Presenca;
import br.org.fiergs.grp.utils.ResizeImage;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {

    private PresencaService presencaService;

    private ResizeImage resizeImage;

    public PdfService(PresencaService presencaService, ResizeImage resizeImage) {
        this.presencaService = presencaService;
        this.resizeImage = resizeImage;
    }

    public void gerarPdf() throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream("arquivo.pdf"));
        document.open();

        // criação da tabela
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setFixedHeight(60); // Definição da altura padrão das células

        // cabeçalho da tabela
        PdfPCell cell = new PdfPCell(new Paragraph("Relatório de Presença"));
        cell.setColspan(3);
//        table.addCell(cell);

        // dados da tabela
        table.addCell("Nome");

        table.addCell("Presença");
        table.addCell("Foto");
//        cell.setFixedHeight(20f);


        List<Presenca> presencaList = presencaService.findByReuniaoId(1L);

        // preenchimento da tabela
//        while (resultSet.next()) {
        String presente = null;
        for (Presenca presenca : presencaList) {
            table.addCell(presenca.getDiretor().getNome());
            if (presenca.getPresente() == null) {
                presente = "Não";
            } else {
                presente = "Sim";
            }
            table.addCell(presente);
            // transformação da imagem de Base64 para JPG
            String base64 = presenca.getDiretor().getFoto();

            int width = 20;
            int height = 20;
//            String resizedBase64Image = resizeImage.resize(base64, width, height);

//            byte[] decodedBytes = Base64.decode(resizedBase64Image);
            byte[] decodedBytes = Base64.decode(base64);
            Image image = Image.getInstance(decodedBytes);
            PdfPCell imageCell = new PdfPCell(image, true);
            table.addCell(imageCell);

        }

        // adição da tabela ao documento
        document.add(table);

        // fechamento do documento
        document.close();

        System.out.println("Arquivo PDF gerado com sucesso!");

    }

}
