public class Warrior extends Character {

    public int warrior(int D1, int D2, int attack, int nbRound) {

        if (D1 == D2) {

                System.out.println(" !!!!! D1 = D2 !!!!! ");
                attack *= 2;
                System.out.println(" **** Attaque doublée pour 3 tours ***** " + nbRound);

        }

        return attack;
    }

}