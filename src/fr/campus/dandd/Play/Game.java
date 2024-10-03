package fr.campus.dandd.Play;

import fr.campus.dandd.Case.Case;
import fr.campus.dandd.Case.CaseEmpty;
import fr.campus.dandd.Case.CaseEnemy;
import fr.campus.dandd.Case.CaseItem;
import fr.campus.dandd.Character.Character;
import fr.campus.dandd.Character.Warrior;
import fr.campus.dandd.Character.Wizard;
import fr.campus.dandd.Item.Weapon;
import fr.campus.dandd.Enemy.Dragon;
import fr.campus.dandd.Enemy.Gobelin;
import fr.campus.dandd.Enemy.Sorcrer;
import fr.campus.dandd.Item.Potion;
import fr.campus.dandd.Item.Spell;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {


    private int round = 0;
    private int position = 0;

    private ArrayList<Case> board = new ArrayList<>();


    public ArrayList<Case> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Case> board) {
        this.board = board;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    Character player = null;


    public String getName() {

        try {
            Scanner obj = new Scanner(System.in);

            System.out.println("Choisissez un nom pour votre personnage : ");

            return obj.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    // choix du type de perso et attribuer la vie et l'attaque

    public static String characterType(String characterPseudo) {

        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        while (choix != 1 && choix != 2) {

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


            choix = scanner.nextInt();

            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre un Guerrier ou un Magicien");
            }
        }

        String characterRole;

        switch (choix) {
            case 1:
                characterRole = "Guerrier";
                break;
            case 2:
                characterRole = "Magicien";
                break;
            default:
                characterRole = "Personnage non reconnu.";
        }

        System.out.println("********************* * * * * * **********************");
        System.out.println(" ");
        System.out.println("  Le personnage choisi est " + characterPseudo + " le " + characterRole);
        System.out.println(" ");
        System.out.println("********************* * * * * * **********************");


        if (characterRole.equals("Guerrier")) {

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
        return characterRole;
    }

    public void createBoard() {

        for (int i = 0; i < 64; i++) {

            Random randomEnemy = new Random();

            int randomType = randomEnemy.nextInt(6) + 1;

            Case currentCase;

            if (randomType == 1) {
                currentCase = new CaseEnemy();
                Gobelin gobelin = new Gobelin();
                gobelin.fight(player);
                ((CaseEnemy) currentCase).setEnemy(gobelin);

            } else if (randomType == 2) {

                currentCase = new CaseEnemy();
                Sorcrer sorcrer = new Sorcrer();
                sorcrer.fight(player);
                ((CaseEnemy) currentCase).setEnemy(sorcrer);


            } else if (randomType == 3) {

                currentCase = new CaseEnemy();
                Dragon dragon = new Dragon();
                dragon.fight(player);
                ((CaseEnemy) currentCase).setEnemy(dragon);

            } else if (randomType == 4) {

                currentCase = new CaseEmpty();

            } else if (randomType == 5) {
                currentCase = new CaseItem();

                Potion potion = new Potion();
                int updatePlayerLife = potion.newPotion(player.getLife());
                player.setLife(updatePlayerLife);

                ((CaseItem) currentCase).setItem(potion);


            } else {

                if (player.getCharacterRole().equals("Guerrier")) {
                    currentCase = new CaseItem();

                    Weapon weapon = new Weapon();
                    int updatePlayerAttack = weapon.warriorWeapon(player.getAttack());
                    player.setAttack(updatePlayerAttack);

                    ((CaseItem) currentCase).setItem(weapon);
                } else if (player.getCharacterRole().equals("Magicien")) {
                    currentCase = new CaseItem();
                    Spell spell = new Spell();
                    int updatePlayerAttack = spell.spellMagician(player.getAttack());
                    player.setAttack(updatePlayerAttack);
                    ((CaseItem) currentCase).setItem(spell);

                } else {

                    currentCase = new CaseEmpty();
                    System.out.print(" erreure création plateau  Guerrier  /  Magicien");
                }
            }

            board.add(currentCase);
        }
    }


    public Game() {
        Menu menu = new Menu();
        menu.welcome();

        // ---------------------------  .Character   ----------------------------- //

        String name = getName();

        String role = characterType(name);

        if (role.equals("Guerrier")) {
            player = new Warrior(name, role);
        } else {
            player = new Wizard(name, role);
        }

        // plateau
        createBoard();

        while (true) {

            System.out.println("  ");
            round++; // compte le nombre de tour

            menu.playOrUpdate();

//            String updateName = menu.playOrUpdate(player.getCharacterName());
//            player.setCharacterName(updateName);

            //   -----------------------------   lancer des D ---------------------------------- // ---   Position Perso --- //
            int updatePosition = menu.gamingDice(round, position);
            setPosition(updatePosition);

            // ---------------------------------  double D ---------------------------------- //

            if (player instanceof Warrior playerAsWarrior) {
                int attack = playerAsWarrior.doubleD(menu.getD1(), menu.getD2(), player.getAttack(), round);
                player.setAttack(attack);

                int updateAttack = playerAsWarrior.updateDoubleD(playerAsWarrior.getupdateRound(), round);
                player.setAttack(updateAttack);
            }

            // ------------------------------  print info joueur ---------------------------- //

            System.out.println(player); // player weapon

            // --------------------------------- création du plateau --------------------------- //

//            Case currentCase = board.get(position);
//            currentCase.interacte(player);

            // **********************************  fin du jeu *************************************** //
            // --------------------------  vie a 0 --------------------------------//
            if (player.getLife() == 0) {

                System.out.println("********************* * * * * * **********************");
                System.out.println("*                                                    *");
                System.out.println("*     Votre personnage est mort fin du jeux !!!      *");
                System.out.println("*                                                    *");
                System.out.println("********************* * * * * * **********************");

                break; // Sorti de la boucle
            }
            // ---------------------------------- sortie du plateau ---------------------------------------//
            if (position >= 64) {
                System.out.println("  ");

                System.out.println("********************* * * * * * **********************");
                System.out.println("*                                                    *");
                System.out.println("*              Gagner  fin du jeux !!!               *");
                System.out.println("*                                                    *");
                System.out.println("********************* * * * * * **********************");
                break; // Sorti de la boucle
            }

        }
    }


}





