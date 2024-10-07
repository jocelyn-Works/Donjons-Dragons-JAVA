package fr.campus.dandd.Play;

import fr.campus.dandd.Character.Character;
import fr.campus.dandd.Character.Warrior;
import fr.campus.dandd.Character.Wizard;
import fr.campus.dandd.Db.Db;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {


    private int D1;
    private int D2;

    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    Character player = null;

    Db db = new Db();


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

    /**
     * desc : Commencer le Jeux
     */
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

    /**
     *  desc : choix entre récuperer  ou crée un personnage
     * @return
     */
    public Character choicePlayer() {

        choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 1 && choice != 2) {

            System.out.println(" 1 / Choisir un Personnage  / 2 Crée un Personnage");

            choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre 1 / OU 2 / ");
            }
        }
        switch (choice) {
            case 1:
                // all Hero
                db.getAllHero();
                System.out.println("  ");
                System.out.println("Veuillez choisir un Personnage ");
                System.out.println("  ");


                choice = 0;

                choice = scanner.nextInt();
                player = db.getOneHero(choice);

                System.out.println(player.getId() + player.getCharacterRole());

                break;

            case 2:

                characterType();
                getName();

                // perso BDD
                player = db.createHero(player.getCharacterRole(), player.getCharacterName(), player.getLife(), player.getAttack());

                System.out.println(player.getId() + player.getCharacterRole());
                break;
        }
        choice = 0;
        return player;
    }

    /**
     * desc : choix du Nom du perssonnage
     */
    public void getName() {

        try {
            Scanner obj = new Scanner(System.in);

            System.out.println("Choisissez un nom pour votre personnage : ");

            player.setCharacterName(obj.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public int  typeChoice() {
        Scanner scanner = new Scanner(System.in);
        choice = 0;
        while (choice != 1 && choice != 2) {

            System.out.println("  ");
            System.out.println("********************* * * * * * **********************");
            System.out.println("*                                                    *");
            System.out.println("*  Choisissez un personnage                          *");
            System.out.println("*                                                    *");
            System.out.println("*    1. Guerrier                                     *");
            System.out.println("*    2. Magicien                                     *");
            System.out.println("*                                                    *");
            System.out.println("********************* * * * * * **********************");
            System.out.println("  ");


            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre un Guerrier ou un Magicien");
            }
        }
        return choice;

    }

    /**
     * desc : Menu du Jeux pour :
     * 1 jouer
     * 2 modification :  ( nom ou role  )
     * 3 Quitter
     */
    public void playOrUpdate() {

        Scanner scanner = new Scanner(System.in);

        while (choice != 1 && choice != 2 && choice != 3) {

            System.out.println("***  1 jouer / 2 Modifier le joueur / 3 Quitter ***");

            choice = scanner.nextInt();
            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Choix invalide. Veuillez choisir entre jouer ou Modifier vos infos ");
            }
        }

        switch (choice) {
            case 1:
                // jouer
                break;
            case 2:

                updateNameOrType();
                break;
            case 3:
                System.out.println(" Vous avez Quitter le Jeux !!!");
                exit(0);
                break;
            default:

        }


    }


    /**
     * desc : choix du type de perso et attribuer la vie et l'attaque
     */
    public void characterType() {

        choice = typeChoice();



        switch (choice) {
            case 1:

                player = new Warrior();
                player.setCharacterRole("Guerrier");


                break;
            case 2:
                player = new Wizard();
                player.setCharacterRole("Magicien");

                break;
            default:
                System.out.println("Personnage non reconnu.");
        }
        choice = 0;

        System.out.println("********************* * * * * * **********************");
        System.out.println(" ");
        System.out.println("  Le personnage choisi est un " + player.getCharacterRole());
        System.out.println(" ");
        System.out.println("********************* * * * * * **********************");


        if (player.getCharacterRole().equals("Guerrier")) {

            int life = 10;
            int attack = 10;

            System.out.println("Niveau de vie : " + life);
            System.out.println("Force  : " + attack);

        } else { // magicien
            int life = 6;
            int attack = 15;

            System.out.println("Niveau de vie : " + life);
            System.out.println("Force  : " + attack);
        }

    }


    /**
     * desc : Modification du Nom ou du Role du perssonnages
     */
    public void updateNameOrType() {

        choice = 0;
        while (choice != 1 && choice != 2) {

            System.out.println("***  Modifier  / 1  Nom  / 2 Type de Personnage  ***");

            Scanner scanner = new Scanner(System.in);

            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre jouer ou Modifier vos infos ");
            }

        }


        switch (choice) {
            case 1:

                Scanner nameScanner = new Scanner(System.in);
                System.out.println("Veuillez modifier votre nom : ");
                String name = nameScanner.nextLine();
                player.setCharacterName(name);
                player = db.updatePlayerName(name, player.getId());

                nameScanner.close();

                playOrUpdate();
                break;
            case 2:

                choice = typeChoice();

                int id = player.getId();
                String namePlayer = player.getCharacterName();

                if (choice == 1) {

                    player = new Warrior();
                    player.setId(id);
                    player.setCharacterName(namePlayer);



                    db.updateTypeHero(player.getCharacterRole(), 10, 10, player.getId());

                    playOrUpdate();

                } else if (choice == 2) {

                    player = new Wizard();
                    player.setId(id);
                    player.setCharacterName(namePlayer);


                    db.updateTypeHero(player.getCharacterRole(), 6, 15, player.getId());


                    playOrUpdate();

                } else {
                    System.out.println("Erreure Modification Role");
                }

                break;
        }

        choice = 0;
        playOrUpdate();

    }


    /**
     *  desc : les 2 dé de jeux + la Position de la case du joueur
     * @param round
     * @param position
     * @return
     */
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

    /**
     * desc : Verifie la vie du joueur
     * si elle est a 0 FIN de JEUX !!!
     */
    public void playerLife() {
        if (player.getLife() == 0) {

            System.out.println("********************* * * * * * **********************");
            System.out.println("*                                                    *");
            System.out.println("*     Votre personnage est mort fin du jeux !!!      *");
            System.out.println("*                                                    *");
            System.out.println("********************* * * * * * **********************");
            exit(0);
            //break; // Sorti de la boucle
        }
    }

}
