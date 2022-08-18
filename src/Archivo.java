import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Archivo {
  Helpers helper = new Helpers();
  String route = "Agenda.txt";

  public void create(String content) {
    try {
      PrintWriter writer = new PrintWriter(new FileOutputStream(new File(route), true));

      writer.append(content + "\n");

      writer.close();
    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e);
    }
  }

  public void read() {
    try {
      File file = new File(route);
  
      BufferedReader obj = new BufferedReader(new FileReader(file));
  
      String line;
      helper.clearScreen();

      while((line = obj.readLine()) != null) {
        System.out.println(line);
      }

      helper.systemPause();
    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e);
    }
  }
}
