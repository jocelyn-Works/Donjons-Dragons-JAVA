import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("************************************************************");
        System.out.println("*****************   Donjons et Dragons   *******************");
        System.out.println("************************************************************");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur 'ENTRER ' pour lancer le jeux");
        scanner.nextLine();

        Game game = new Game();
    }
}


