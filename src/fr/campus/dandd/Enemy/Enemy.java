package fr.campus.dandd.Enemy;

import fr.campus.dandd.Character.Character;
import fr.campus.dandd.Db.Db;
import fr.campus.dandd.Play.Game;

import java.util.Scanner;

public abstract class Enemy {

    private String enemyName;
    int enemyAttack;
    int enemyLife;

    int choix = 0;

    Db db = new Db();


    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyLife() {
        return enemyLife;
    }

    public void setEnemyLife(int enemyLife) {
        this.enemyLife = enemyLife;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    /**
     *  desc : Instacie un Combat entre un Ennemie et le Joueur
     * @param player
     */
    public void fight(Character player) {

        System.out.println("  ");
        System.out.println(" Vous etes tomber sur un " + getEnemyName() + " !!!!");
        System.out.println(" ");
        System.out.println("attack  : " + enemyAttack + " " + " vie : " + enemyLife);


        while (player.getLife() >= 0 && getEnemyLife() >= 0) {

            System.out.println("le " + getEnemyName() + " vous attaque de " + getEnemyAttack() + " ");

            player.setLife(player.getLife() - getEnemyAttack());
            db.updatelifeHero(player.getLife(), player.getId());
            System.out.println("Votre vie actuelle : " + player.getLife());


            setEnemyLife(getEnemyLife() - player.getAttack());


            while (choix != 1 && choix != 2) {
                Scanner scanner = new Scanner(System.in);

                System.out.println(" 1 / Attaquer / 2 Quitter");

                choix = scanner.nextInt();
                if (choix != 1 && choix != 2 && choix != 3) {
                    System.out.println("Choix invalide. Veuillez choisir entre Attaquer ou Quitter ");
                }
            }

            switch (choix) {
                case 1:
                    // jouer
                    break;
                case 2:
                    System.out.println(" Vous avez Quitter le Jeux !!!");
                    System.exit(0);

                    break;

            }


            System.out.println("Vous attaquez l'ennemi de " + player.getAttack() + " points de dégâts!");
            System.out.println("Vie de l'ennemi actuelle : " + getEnemyLife());


            if (getEnemyLife() <= 0) {
                System.out.println("Vous avez tué" + getEnemyName() + " !");
                break;
            }
            if (player.getLife() <= 0) {
                System.out.println("Vous avez Perdu contre " + getEnemyName() + " !");
                break;
            }

            System.out.println(" ");
            System.out.println("********************* * * * * * **********************");


        }

        System.out.println("  ");


    }


}
