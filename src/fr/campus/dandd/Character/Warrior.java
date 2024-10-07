package fr.campus.dandd.Character;

public class Warrior extends Character {
    private int updateRound;

    /**
     * dsc : personnage Guerrier avec ces atibuts Role , vie et attaque
     */
    public Warrior() {
        setCharacterRole("Guerrier");
        setLife(10);
        setAttack(10);
    }


    public int getupdateRound() {
        return updateRound;
    }

    /**
     * desc : Double de dés égaux
     * @param D1
     * @param D2
     * @param attack
     * @param round
     * @return le Guerrier a une attaque doublé pendant 3 tours
     */
    public int doubleD(int D1, int D2, int attack, int round) {

        if (D1 == D2) {
            attack *= 2;

            updateRound = round + 3;
            System.out.println(" ****  Double D1 = D2  *** ");
        }

        return attack;
    }

    /**
     * desc : calcul les 3 de tours
     * @param thirdRound
     * @param round
     * @return remmet l'attaque du Guerrier a sa valeur initiale apres les 3 tours
     */
    public int updateDoubleD(int thirdRound, int round) {

        if (thirdRound == round) {

            attack /= 2;
        }
        return attack;

    }


}