package fr.campus.dandd.Enemy;


public class Gobelin extends Enemy{



    public Gobelin() {
        setEnemyName("Gobelin");
        setEnemyAttack(1);
        setEnemyLife(6);
        System.out.println("********************* * * * * * **********************");


    }

    public String toString() {
        return "ennemi : "+ getEnemyName() + ",  enemyAttack : " + enemyAttack + ", vie de : " + enemyLife ;
    }


}
