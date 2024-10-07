package fr.campus.dandd.enemy;


public class Sorcerer extends Enemy {

    /**
     * desc : Création d'un Sorcier aves son Nom , sa Vie et son Attaque
     */
    public Sorcerer() {
        setEnemyName("Sorcier");
        setEnemyAttack(2);
        setEnemyLife(9);
        System.out.println("********************* * * * * * **********************");

        System.out.println("          .^!?5PBBBPY7^.                          \n" +
                "       .^!?YP#&&##@@@@@#P?:                       \n" +
                "   ^!7?YPB&@@@@@@@@@@@&&@@&5^                     \n" +
                "  ^Y5&&####&#?7@@@@@&PG@@@@@@5^                   \n" +
                " ^Y5&Y^ ...:5  #@@@P?#@@@@@@@@@5^                 \n" +
                "!PB5:       ~Y Y@#7?&PG@@@@@@@@@@P~               \n" +
                "&G~          77:P^!?JG@@@@@@@@@@&#BP!             \n" +
                "?.            ?!  :Y&@@@@@@@@@@@@&BGGP7..         \n" +
                "          .~  .5.!B@@@@@@@@@@&#G5Y5YYJYYJJJYY?!^. \n" +
                "       .:  :  ?Y?B@@@@@@@@&GY7J5GBJ!~^!P&@@@@@#P! \n" +
                "       :7   :!??B@@@@@@#BG5P#&BBG#PP?7Y5#&GY!^.   \n" +
                "        .^~!!7Y#@@&#BGGB#@&PY5YP&7~@PJ7BP.        \n" +
                "    :7!??JYPB##BGPGG##P@@@@&GG@@@J:@#J.BY         \n" +
                "    :!!?JJYYYYYB&@@?#J?@#5G57!Y@@#:J~:.PJ:        \n" +
                "   . ..  ..   :#@@B:P ?B@&B?:?BBG&^5? J5^!        \n" +
                "  .  5Y    ^~!J#@@5Y~ J5&@&YJYGP77!?YJ5Y ?.       \n" +
                "    .~.   7!7B@@@@&Y  YB#5~^?Y^!7?55^^J5 !5       \n" +
                " :!     ^?!~P@@@@@@7: B@! !B7 ~@#5G@&!^G~~&B!     \n" +
                " .: .:^!!7P#&@@@@@@5 7#B: Y5  ?P.  :55 ^?7&@B     \n" +
                "  ~!777!?JY5PG#&&@@7^@5~? P?  ^~~. ~ Y^ :.?&Y7!   \n" +
                " .5^##GPPPGB#&@@@@@B5@~ 5^B~   :G.7! ?: :? 7#&@!  \n" +
                " ~J.Y5B&@@@@@@@@@@@@@@? B#PJ^  J?!? :7!:.#?~@@@B .\n" +
                " J7P&@@@@@@&@@@@@@@@@@&^5@G~5. !?~?  7!! G&J@@BY: \n" +
                " !G&@@@@@@@@@@@@@@@@@@@&B&#7:?^ ^!!7 .!^ 5@@#5!^. \n" +
                "  .!YG#&&&@@@@@@@@@@@@@@@@&G!:J?. .P..~  B&P?^.   \n" +
                "     .~7PPPGB##&&@@@@@@@@@@@@GJ7Y^ ! J5^!5~:      \n" +
                "        .:!!!77?JYPGB###&&&&&@@B75  ~Y7P^         \n" +
                "             .:::::^~~~!!!7???!JYJ:P! !!          \n" +
                "                  ..            :5?:  .           \n" +
                "                                .7                  ");


    }

    public String toString() {
        return
                "ennemi : "+ getEnemyName() + ",  enemyAttack : " + enemyAttack + ", vie de : " + enemyLife ;
    }


}
