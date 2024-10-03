package fr.campus.dandd.Play;

import fr.campus.dandd.Character.Character;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {


    private static int choix = 0;

    private int D1;
    private int D2;


    Character player = null;


    public int getD1() {
        return D1;
    }

    public void setD1(int D1) {
        this.D1 = D1;
    }

    public int getD2() {
        return D2;
    }

    public void setD2(int D2) {
        this.D2 = D2;
    }

    public Menu() {

    }

    public void welcome() {
        
        System.out.println("  ");
        System.out.println("********************* * * * * * **********************");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("****************   Donjons et Dragons   **************");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("********************* * * * * * **********************");
        System.out.println("  ");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur ' ENTRER ' pour lancer le jeux");
        scanner.nextLine();
    }


    public void playOrUpdate() {

        Scanner scanner = new Scanner(System.in);

        while (choix != 1 && choix != 2 && choix != 3) {

            System.out.println("***  1 jouer / 2 Modifier le joueur/ 3 Quitter ***");

            choix = scanner.nextInt();
            if (choix != 1 && choix != 2 && choix != 3) {
                System.out.println("Choix invalide. Veuillez choisir entre jouer ou Modifier vos infos ");
            }
        }

        switch (choix) {
            case 1:
                // jouer
                break;
            case 2:

                updateNameOrType();

            case 3:
                System.out.println(" Vous avez Quitter le Jeux !!!");
                exit(0);
                break;

        }

    }



    public void updateNameOrType() {

        int choice = 0;
        while (choice != 1 && choice != 2) {

            System.out.println("***  Mmodifier  / 1  Nom  / 2 Type de Personnage  ***");

            Scanner scanner = new Scanner(System.in);

            choice = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre jouer ou Modifier vos infos ");
            }
        }
        switch (choice) {
            case 1:

                String updateName = updateName(player.getCharacterName());
                player.setCharacterName(updateName);

                break;
            case 2:


                String updateType = Game.characterType(player.getCharacterName());
                player.setCharacterName(updateType);


        }


    }

    public String updateName(String name) {

        Scanner nameScane = new Scanner(System.in);
        System.out.println("Veuillez modifier votre nom : ");
        name = nameScane.nextLine();
        player.setCharacterName(name);
        return name;

    }


    public int gamingDice(int round, int position) {

        System.out.println("  ");
        System.out.println("********************* * * * * * **********************");

        System.out.println("                      Tour n° " + round);

        System.out.println("  ");
        Random random = new Random();
        D1 = random.nextInt(6) + 1;
        D2 = random.nextInt(6) + 1;

        System.out.println("  lancer =>  D1 : " + D1 + "  D2 : " + D2);
        int totalD = D1 + D2;
        int updatePosition = position + totalD;
        System.out.println("  total : " + totalD);
        System.out.println("  ");
        System.out.println("  Tu est sur la case  n° " + updatePosition);

        return updatePosition;
    }

}
