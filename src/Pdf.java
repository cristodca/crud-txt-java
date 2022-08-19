import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Pdf {
  String route = "Agenda.txt";

  public void generate() {
    try {
      PDDocument pdfDoc = new PDDocument();
      PDPage page = new PDPage();
      PDFont font = PDType1Font.HELVETICA;
      
      pdfDoc.addPage(page);

      PDPageContentStream contentStream = new PDPageContentStream(pdfDoc, page);
      contentStream.setFont(font, 16);

      File file = new File(route);
      BufferedReader obj = new BufferedReader(new FileReader(file));

      String line;

      contentStream.beginText();
      contentStream.newLineAtOffset(25, 700);
      contentStream.setLeading(14.5f);
      while ((line = obj.readLine()) != null) {
        String[] formato = line.split("#");
        contentStream.showText(formato[0] + " - " + formato[1] + " - " + formato[2]);
        contentStream.newLine(); 
      }
      contentStream.endText();

      obj.close();

      contentStream.close();

      pdfDoc.save("Agenda.pdf");
      pdfDoc.close();
      System.out.println("El PDF fue creado correctamente");
    } catch (Exception e) {
      System.out.println("Ocurrio un problema generando el PDF");
      //TODO: handle exception
    }
  }
}
