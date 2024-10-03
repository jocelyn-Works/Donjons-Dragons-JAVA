package fr.campus.dandd.Case;

import fr.campus.dandd.Enemy.Enemy;
import fr.campus.dandd.Character.Character;

public class CaseEnemy implements Case {

    private Enemy enemy ;

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void interacte(Character player){
        enemy.fight(player);
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
