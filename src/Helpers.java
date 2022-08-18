public class Helpers {
  public void clearScreen() {
    System.out.print("\033[H\033[2J");
  }

  public void systemPause() {
    System.out.println("");
    System.out.println("Presione cualquier tecla para continuar...");
    new java.util.Scanner(System.in).nextLine();
  }
}
