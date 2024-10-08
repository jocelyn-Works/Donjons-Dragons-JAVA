package fr.campus.dandd.item;

import java.util.Scanner;

public class Weapon extends EquipmentOffensive {


    public Weapon() {

    }

    /**
     *  desc : Menu: Choix dune arme pour le joueur
     * @param attack  récuperer l'attaque du joueur
     * @return la nouvelle attaque du joueur
     */
    public int warriorWeapon(int attack) {
        int choix = 0;


        while (choix != 1 && choix != 2) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("  ");
            System.out.println("********************* * * * * * **********************");
            System.out.println("*                                                    *");
            System.out.println("*      Choisissez une arme pour votre Guerrier :     *");
            System.out.println("*                                                    *");
            System.out.println("*  1. Massue : augmente l’attaque de 3 points        *");
            System.out.println("*  2. Epée : augmente l’attaque de 5 points          *");
            System.out.println("*                                                    *");
            System.out.println("********************* * * * * * **********************");
            System.out.println("  ");


            choix = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre une  Massue ou une Epée ");
            }
        }

        switch (choix) {
            case 1:
                setWeapon("Massue");
                attack += 3;

                break;
            case 2:
                setWeapon("Epée");
                attack += 5;

                break;
        }
        return attack;

    }

    public String toString() {
        return "Votre  arme : " + getWeapon() + "\n";
    }
}


