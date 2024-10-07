package fr.campus.dandd.cases;

import fr.campus.dandd.enemy.Enemy;
import fr.campus.dandd.character.Character;

public class CaseEnemy implements Case {

    private Enemy enemy ;

    public Enemy getEnemy() {
        return enemy;
    }

    /**
     *  desc : Initie un combat entre un ennemi et un joueur
     * @param player récuper le joueur et ces attributs ( vie , attaque ... )
     */
    @Override
    public void interacte(Character player){
        enemy.fight(player);
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
