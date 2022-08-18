import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Archivo {
  Helpers helper = new Helpers();
  String route = "Agenda.txt";

  public void create(String content, Boolean shouldAppend) {
    try {
      PrintWriter writer = new PrintWriter(new FileOutputStream(new File(route), shouldAppend));

      if (shouldAppend) {
        writer.append(content + "\n");
      } else {
        writer.write(content);
      }

      writer.close();
    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e);
    }
  }

  public void read(Boolean shouldPause) {
    try {
      File file = new File(route);

      BufferedReader obj = new BufferedReader(new FileReader(file));

      String line;
      helper.clearScreen();

      System.out.println("CONTACTOS");

      while ((line = obj.readLine()) != null) {
        String[] formato = line.split("#");
        System.out.println("------------");
        System.out.println("| Nombre:" + formato[1]);
        System.out.println("| Telefono: " + formato[0]);
        System.out.println("| Correo:" + formato[2]);
        System.out.println("------------");
      }

      obj.close();

      if (shouldPause) {
        helper.systemPause();
      }
    } catch (Exception e) {
      System.out.println("Ocurrio un error: " + e);
    }
  }

  public void update(String phoneToEdit, String newPhone, String newName, String newEmail) {
    try {
      File file = new File(route);

      BufferedReader obj = new BufferedReader(new FileReader(file));

      String line;
      Boolean contactWasFound = false;
      String editFileInformation = "";
      helper.clearScreen();

      while ((line = obj.readLine()) != null) {
        if (line.contains(phoneToEdit + "#")) {
          contactWasFound = true;
          editFileInformation += newPhone + "#" + newName + "#" + newEmail + "\n";
        } else {
          editFileInformation += line + "\n";
        }
      }

      obj.close();

      if (contactWasFound) {
        create(editFileInformation, false);
        System.out.println("Se ha editado el contacto: " + phoneToEdit);
      } else {
        System.out.println("No se ha encontrado ningun contacto con el numero de telefono: " + phoneToEdit);
      }
    } catch (Exception e) {
      System.out.println("Ocurrio un problema: " + e);
    }
  }

  public void delete(String phoneToDelete) {
    try {
      File file = new File(route);

      BufferedReader obj = new BufferedReader(new FileReader(file));

      String line;
      Boolean contactWasFound = false;
      String editFileInformation = "";
      helper.clearScreen();

      while ((line = obj.readLine()) != null) {
        if (line.contains(phoneToDelete + "#")) {
          contactWasFound = true;
        } else {
          editFileInformation += line + "\n";
        }
      }

      obj.close();

      if (contactWasFound) {
        create(editFileInformation, false);
        System.out.println("Se ha eliminado el contacto: " + phoneToDelete);
      } else {
        System.out.println("No se ha encontrado ningun contacto con el numero de telefono: " + phoneToDelete);
      }
    } catch (Exception e) {
      System.out.println("Ocurrio un problema: " + e);
    }
  }

  public boolean phoneExists(String phoneToSearch) {
    try {
      File file = new File(route);

      BufferedReader obj = new BufferedReader(new FileReader(file));

      String line;
      Boolean contactWasFound = false;

      while ((line = obj.readLine()) != null) {
        if (line.contains(phoneToSearch + "#")) {
          contactWasFound = true;
        }
      }

      obj.close();

      if (contactWasFound) {
        return true;
      }

      return false;

    } catch (Exception e) {
      return false;
    }
  }
}
