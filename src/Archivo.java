import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Archivo {

  public void create(String content) {
    try {
      String route = "Agenda.txt";
      // String charset = "UTF-8";

      PrintWriter writer = new PrintWriter(new FileOutputStream(new File(route), true));

      writer.append(content + "\n");

      writer.close();
    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e);
    }
  }
}
