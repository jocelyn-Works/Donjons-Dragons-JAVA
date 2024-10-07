package fr.campus.dandd.Item;

import fr.campus.dandd.Character.Character;
import fr.campus.dandd.Db.Db;

import java.util.Scanner;

public class Potion extends EquipmentOffensive {


    public Potion() {

    }


    /**
     *  desc : Menu Choix dune potion pour le joueur
     * @param life  récuperer la vie du joueur
     * @return  nouvelle potion du joueur
     */
    public int newPotion(int life) {
    int choix = 0;

        Scanner scanner = new Scanner(System.in);
        while (choix != 1 && choix != 2) {

            System.out.println("********************* * * * * * **********************");
            System.out.println("*    Vous etes tomber sur une  potions !!!!          *");
            System.out.println("*                                                    *");
            System.out.println("*        Choisissez une potions  :                   *");
            System.out.println("*                                                    *");
            System.out.println("*  1. Potion de vie standard : rends 2 points de vie *");
            System.out.println("*  2. Grande potion de vie : rends 5 points de vie   *");
            System.out.println("*                                                    *");
            System.out.println("********************* * * * * * **********************");


            choix = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre une Potion ou une Grande potion");
            }
        }

        switch (choix) {
            case 1:
                life += 2;
                setPotion("Potion standard");
                break;
            case 2:
                life += 5;
                setPotion("Grande potion");
                break;
        }

        return life ;
    }
}
