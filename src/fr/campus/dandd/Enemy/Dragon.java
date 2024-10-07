package fr.campus.dandd.Enemy;

public class Dragon extends Enemy {


    /**
     * desc : Création d'un Dragon aves son Nom , sa Vie et son Attaque
     */
    public Dragon() {
        setEnemyName("Dragon");
        setEnemyAttack(4);
        setEnemyLife(15);


        System.out.println("********************* * * * * * **********************");

        System.out.println("\n" +
                "       ---_ ......._-_--.\n" +
                "      (|\\ /      / /| \\  \\\n" +
                "      /  /     .'  -=-'   `.\n" +
                "     /  /    .'             )\n" +
                "   _/  /   .'        _.)   /\n" +
                "  / o   o        _.-' /  .'\n" +
                "  \\          _.-'    / .'*|\n" +
                "   \\______.-'//    .'.' \\*|\n" +
                "    \\|  \\ | //   .'.' _ |*|\n" +
                "     `   \\|//  .'.'_ _ _|*|\n" +
                "      .  .// .'.' | _ _ \\*|\n" +
                "      \\`-|\\_/ /    \\ _ _ \\*\\\n" +
                "       `/'\\__/      \\ _ _ \\*\\\n" +
                "      /^|            \\ _ _ \\*\n" +
                "     '  `             \\ _ _ \\\n" +
                "                       \\_\n");


    }


    @Override
    public String toString() {
        return
               "ennemi : "+ getEnemyName() + ",  enemyAttack : " + enemyAttack + ", vie de : " + enemyLife ;
    }




    public void fight(Character player) {
    }
}
