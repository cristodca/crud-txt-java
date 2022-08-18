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

  public void delete() {
    String phoneToEdit;

    Scanner in = new Scanner(System.in);

    helper.clearScreen();
    file.read(false);
    
    System.out.println("*********************");
    System.out.println("INGRESE EL NUMERO DE TELEFONO DEL CONTACTO A ELIMINAR: ");
    phoneToEdit = in.nextLine();

    if (phoneToEdit != "") {
      file.delete(phoneToEdit);
    } else {
      System.out.println("Es necesario ingresar un numero de telefono para realizar la busqueda");
    }

    helper.systemPause();
  }
}
