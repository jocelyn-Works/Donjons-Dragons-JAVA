package fr.campus.dandd.play;

import fr.campus.dandd.cases.Case;
import fr.campus.dandd.cases.CaseEmpty;
import fr.campus.dandd.cases.CaseEnemy;
import fr.campus.dandd.cases.CaseItem;
import fr.campus.dandd.character.Character;
import fr.campus.dandd.character.Warrior;
import fr.campus.dandd.item.Weapon;
import fr.campus.dandd.enemy.Dragon;
import fr.campus.dandd.enemy.Gobelin;
import fr.campus.dandd.enemy.Sorcerer;
import fr.campus.dandd.item.Potion;
import fr.campus.dandd.item.Spell;
import fr.campus.dandd.db.Db;


import java.util.ArrayList;

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

    Db db = new Db();

    Character player;


    /**
     * desc : Création du plateau avec la position aléatoire
     * d'un Ennemi ( Gobelin , Dragon , Sorcier )
     *  d'une Case Vide
     *  d'une Potion
     *  d'une Arme en fonction du Role choisie par le joueur
     *
     */
    public void createBoard() {

            Case currentCase = new CaseEmpty();
            int i = position;

            switch (i) {
                case 45: case 52: case 56: case 62:
                    currentCase = new CaseEnemy();
                    Dragon dragon = new Dragon();
                    dragon.fight(player);
                    ((CaseEnemy) currentCase).setEnemy(dragon);
                    break;

                case 10: case 20: case 25: case 32: case 35:
                case 36: case 37: case 40: case 44: case 47:
                    currentCase = new CaseEnemy();
                    Sorcerer sorcerer = new Sorcerer();
                    sorcerer.fight(player);
                    ((CaseEnemy) currentCase).setEnemy(sorcerer);
                    break;

                case 3: case 6: case 9: case 12: case 15:
                case 18: case 21: case 24: case 27: case 30:
                    currentCase = new CaseEnemy();
                    Gobelin gobelin = new Gobelin();
                    gobelin.fight(player);
                    ((CaseEnemy) currentCase).setEnemy(gobelin);
                    break;



                case 2: case 11: case 5: case 22: case 38: case 19: case 26: case 42: case 53:
                if(player.getCharacterRole().equals("Guerrier")){

                    currentCase = new CaseItem();
                    Weapon weapon = new Weapon();
                    int updateClubAttack = weapon.warriorWeapon(player.getAttack());
                    player.setAttack(updateClubAttack);
                    db.updateWeaponnHero(weapon.getWeapon(), player.getId());
                    db.updateAtackHero(player.getAttack(), player.getId());
                    ((CaseItem) currentCase).setItem(weapon);
                }
                    break;



                case 1: case 4: case 8: case 17: case 23:  case 48: case 49:
                    if(player.getCharacterRole().equals("Magicien")){

                        currentCase = new CaseItem();
                        Spell spell = new Spell();
                        int updateLightningAttack = spell.spellMagician(player.getAttack());
                        player.setAttack(updateLightningAttack);
                        db.updateWeaponnHero(spell.getWeapon(), player.getId());
                        db.updateAtackHero(player.getAttack(), player.getId());
                        ((CaseItem) currentCase).setItem(spell);
                    }
                    break;



                case 7: case 13: case 31: case 33: case 39: case 43:  case 28: case 41:
                    currentCase = new CaseItem();
                    Potion potion = new Potion();
                    int updatePlayerLife = potion.newPotion(player.getLife());
                    player.setLife(updatePlayerLife);
                    db.updatelifeHero(player.getLife(), player.getId());
                    db.updatePotionHero(potion.getPotion(), player.getId());
                    ((CaseItem) currentCase).setItem(potion);
                    break;


                default:
                    currentCase = new CaseEmpty();
                    break;
            }

            board.add(currentCase);

    }



    /**
     * desc : lancer le jeu avec l'appel des méthodes
     * dans un ordre précis pour construire le Jeux
     */
    public void play() {

        Menu menu = new Menu();
        menu.welcome();
        player = menu.choicePlayer();




        while (true) {

            System.out.println("  ");
            round++; // compte le nombre de tour

            menu.playOrUpdate();


            //   -----------------------------   lancer les D -------------- // ---   Position Perso --- //
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
            // ------------------------------------ Plateau ------------------------------------ //

            createBoard();
//            Case currentCase = board.get(position);
//            currentCase.interacte(player);

            // **********************************  fin du jeu *************************************** //
            // --------------------------  vie a 0 --------------------------------//

            menu.playerLife();
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





