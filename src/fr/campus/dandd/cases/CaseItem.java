package fr.campus.dandd.cases;


import fr.campus.dandd.item.Item;
import fr.campus.dandd.character.Character;

public class CaseItem implements Case {

    private Item item;

    /**
     *  desc : Initie une case Item ( une arme ou un sort ) ou une potion
     * @param player récuper le joueur et ces attributs ( vie , attaque ... )
     */
    @Override
    public void interacte(Character player) {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
