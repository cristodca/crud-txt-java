import java.util.Scanner;

public class Contact {
  Helpers helper = new Helpers();
  Archivo file = new Archivo();

  public void create() {
    String name, email, phone;

    Scanner in = new Scanner(System.in);

    helper.clearScreen();

    System.out.println("AGREGAR NUEVO CONTACTO");
    System.out.println("");
    System.out.print("Nombre completo: ");
    name = in.nextLine();

    System.out.print("Numero telefono: ");
    phone = in.nextLine();

    System.out.print("Correo electronico: ");
    email = in.nextLine();

    file.create(phone + "#" + name + "#" + email, true);

    helper.systemPause();
  }

  public void update() {
    Scanner in = new Scanner(System.in);
    String phoneToSearch;

    helper.clearScreen();
    file.read(false);

    System.out.println("*********************");
    System.out.println("INGRESE EL NUMERO DE TELEFONO DEL CONTACTO A EDITAR: ");
    phoneToSearch = in.nextLine();

    if (phoneToSearch != "" && file.phoneExists(phoneToSearch)) {
      String newPhone, newName, newEmail;

      helper.clearScreen();

      System.out.println("Nuevo nombre del contacto:");
      newName = in.nextLine();

      System.out.println("Nuevo numero de telefono:");
      newPhone = in.nextLine();

      System.out.println("Nuevo correo:");
      newEmail = in.nextLine();

      file.update(phoneToSearch, newPhone, newName, newEmail);
    } else {
      System.out.println("El numero de telefono ingresado no existe en la agenda");
    }

    helper.systemPause();
  }

  public void delete() {
    String phoneToDelete;

    Scanner in = new Scanner(System.in);

    helper.clearScreen();
    file.read(false);

    System.out.println("*********************");
    System.out.println("INGRESE EL NUMERO DE TELEFONO DEL CONTACTO A ELIMINAR: ");
    phoneToDelete = in.nextLine();

    if (phoneToDelete != "") {
      file.delete(phoneToDelete);
    } else {
      System.out.println("Es necesario ingresar un numero de telefono para realizar la busqueda");
    }

    helper.systemPause();
  }
}
