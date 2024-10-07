package fr.campus.dandd.item;

abstract class DefensiveEquipment extends Item {

    String shield;
    int defensif;

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        shield = shield;
    }

    public int getDefensif() {
        return defensif;
    }

    public void setDefensif(int defensif) {
        defensif = defensif;
    }



    public String toString() {
        return "Votre  bouclier : " + shield + "\n" + " Niveau de defense : " + defensif;
    }

}
