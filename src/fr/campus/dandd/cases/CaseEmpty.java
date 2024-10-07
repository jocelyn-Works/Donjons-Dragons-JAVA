package fr.campus.dandd.cases;
import fr.campus.dandd.character.Character;

public class CaseEmpty implements Case {


    @Override
    public void interacte(Character player) {

    }

    /**
     *  desc : création d'une case vide
     */
    public CaseEmpty() {
        System.out.println("  ");
        System.out.println("********************* * * * * * **********************");
        System.out.println("*                                                    *");
        System.out.println("*       Vous etes tomber sur une case vide !!!!      *");
        System.out.println("*                                                    *");
        System.out.println("********************* * * * * * **********************");

        System.out.println("  ");

    }
}
