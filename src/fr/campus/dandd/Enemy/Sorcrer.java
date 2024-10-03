package fr.campus.dandd.Enemy;


public class Sorcrer extends Enemy {


    public Sorcrer() {
        setEnemyName("Sorcier");
        setEnemyAttack(2);
        setEnemyLife(9);
        System.out.println("********************* * * * * * **********************");

    }

    public String toString() {
        return
                "ennemi : "+ getEnemyName() + ",  enemyAttack : " + enemyAttack + ", vie de : " + enemyLife ;
    }


}
