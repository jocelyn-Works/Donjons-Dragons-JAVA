package fr.campus.dandd.Case;
import fr.campus.dandd.Character.Character;

public class CaseEmpty implements Case {


    @Override
    public void interacte(Character player) {

    }

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
