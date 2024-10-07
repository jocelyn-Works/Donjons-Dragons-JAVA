package fr.campus.dandd.Enemy;


public class Gobelin extends Enemy{


    /**
     * desc : Création d'un Gobelin aves son Nom , sa Vie et son Attaque
     */
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
