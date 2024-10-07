package fr.campus.dandd.Enemy;


public class Sorcrer extends Enemy {

    /**
     * desc : Création d'un Sorcier aves son Nom , sa Vie et son Attaque
     */
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
