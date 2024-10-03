package fr.campus.dandd.Item;

import java.util.Scanner;

public class Spell extends EquipmentOffensive {
    public Spell() {

    }
    public int spellMagician( int attack) {

        int choix = 0;
        while (choix != 1 && choix != 2) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("  ");
            System.out.println("********************* * * * * * **********************");
            System.out.println("*                                                    *");
            System.out.println("*      Choisissez une arme pour votre magicien :     *");
            System.out.println("*                                                    *");
            System.out.println("*  1. Eclair: augmente l’attaque de 2 points         *");
            System.out.println("*  2. Boule de feu : augmente l’attaque de 7 points  *");
            System.out.println("*                                                    *");
            System.out.println("********************* * * * * * **********************");
            System.out.println("  ");



            choix = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre un Eclair ou une Boule de feu ");
            }
        }

        switch (choix) {
            case 1:
               setWeapon("Eclair");
                attack += 2;
                break;
            case 2:
                setWeapon("Boule de feu");
                attack += 7;
                break;
        }
    return attack;
    }

}
