package fr.campus.dandd.Character;

public class Warrior extends Character {
    private  int updateRound;


    public Warrior() {

        setLife(10);
        setAttack(10);
    }




    public int getupdateRound() {
        return updateRound;
    }



    public int doubleD(int D1, int D2, int attack, int round) {

        if (D1 == D2) {
            attack *= 2;

            updateRound = round + 3;
            System.out.println(" ****  Double D1 = D2  *** ");
        }

        return attack;
    }

    public int updateDoubleD(int thirdRound, int round) {

        if (thirdRound == round){

            attack /= 2;
        }
        return attack;

    }


}