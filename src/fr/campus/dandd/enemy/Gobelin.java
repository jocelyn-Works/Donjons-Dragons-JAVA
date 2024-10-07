package fr.campus.dandd.enemy;


public class Gobelin extends Enemy{


    /**
     * desc : Création d'un Gobelin aves son Nom , sa Vie et son Attaque
     */
    public Gobelin() {
        setEnemyName("Gobelin");
        setEnemyAttack(1);
        setEnemyLife(6);
        System.out.println("********************* * * * * * **********************");

        System.out.println("          ,      ,     \n" +
                "         /(.-\"\"-.)\\   \n" +
                "     |\\  \\/      \\/  /|  \n" +
                "     | \\ / =.  .= \\ / | \n" +
                "     \\( \\   o\\/o   / )/  \n" +
                "      \\_, '-/  \\-' ,_/   \n" +
                "        /   \\__/   \\   \n" +
                "        \\ \\__/\\__/ /  \n" +
                "      ___\\ \\|--|/ /___ \n" +
                "    /`    '--'--'    `\\ \n" +
                "   /                  \\ \n" +
                "  /.-|\\            /|-.\\ \n");




    }

    public String toString() {
        return "ennemi : "+ getEnemyName() + ",  enemyAttack : " + enemyAttack + ", vie de : " + enemyLife ;
    }


}
