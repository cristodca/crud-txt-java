import java.util.Scanner;

public class Menu {
  Contact contact = new Contact();
  Helpers helper = new Helpers();
  Archivo archivo = new Archivo();

  public void show() {
    helper.clearScreen();
    System.out.println("============");
    System.out.println("1. Agregar nuevo contacto");
    System.out.println("2. Ver agenda");
    System.out.println("3. Modificar un contacto");
    System.out.println("4. Eliminar un contacto");
    System.out.println("5. Descargar agenda en PDF");
    System.out.println("9. Salir");
    System.out.println("============");
  }

  public int getResponse() {
    int opt;

    Scanner in = new Scanner(System.in);

    System.out.println("SELECCIONA OPCION:");
    opt = in.nextInt();

    switch(opt) {
      case 1:
        contact.create();
      break;
      case 2:
        archivo.read(true);
      break;
      case 4:
        contact.delete();
      break;
      default:
        helper.clearScreen();
        System.out.println("Por favor asegurese de seleccionar una opcion valida");
        helper.systemPause();
      break;
    }

    return opt;
  }
}
