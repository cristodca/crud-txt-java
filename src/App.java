public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        
        do {
            menu.show();
        } while (menu.getResponse() != 9);
    }
}
