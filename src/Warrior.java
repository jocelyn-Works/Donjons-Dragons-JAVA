public class Warrior extends Character {
    private  int updateRound;

    public int getupdateRound() {
        return updateRound;
    }



    public int warrior(int D1, int D2, int attack, int round) {

        if (D1 == D2) {
            attack *= 2;

            updateRound = round + 3;
            System.out.println(" ****  Double D1 = D2  *** ");
        }

        return attack;
    }

    public void updateDoubleD(int thirdRound, int round) {

        if (thirdRound == round){
            attack /= 2;
        }

    }


}