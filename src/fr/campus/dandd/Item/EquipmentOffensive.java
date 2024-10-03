package fr.campus.dandd.Item;

public abstract class EquipmentOffensive extends Item {

    private String weapon;
    private String potion;

    private int choix = 0;



    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String weapon) {
        this.potion = potion;
    }

    public EquipmentOffensive() {

    }






    public String toString() {
        return "Votre  arme : " + weapon + "\n" + "Votre Potions : " + potion;
    }
}
