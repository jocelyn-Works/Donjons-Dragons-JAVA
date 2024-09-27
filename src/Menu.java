import java.util.Scanner;

public class Menu {

    private String Command;
    private int choix = 0;

    public Menu() {


    }

    public String playOrUpdate(String name) {

        Scanner scanner = new Scanner(System.in);

        while (choix != 1 && choix != 2) {

            System.out.println("***  1 jouer / 2 Modifier vos infos ");

            choix = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre jouer ou Modifier vos infos ");
            }
        }

        switch (choix) {
            case 1:
                // jouer
                break;
            case 2:
                Scanner nameScane= new Scanner(System.in);
                System.out.println("Veuillez modifier votre nom : ");
                name = nameScane.nextLine();
                break;
        }
        return name;

    }



}
