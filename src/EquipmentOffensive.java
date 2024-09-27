import java.util.Scanner;

abstract class EquipmentOffensive {

    private String Weapon;
    private String Potion;

    private int choix = 0;

    public String getWeapon() {
        return Weapon;
    }

    public void setWeapon(String weapon) {
        this.Weapon = weapon;
    }

    public String getPotion() {
        return Potion;
    }

    public void setPotion(String weapon) {
        this.Potion = Potion;
    }

    public EquipmentOffensive() {

    }


    public int potions(int life) {


        Scanner scanner = new Scanner(System.in);
        while (choix != 1 && choix != 2) {

            System.out.println("*************** * * * * * ***************");

            System.out.println("Choisissez une potions  : ");
            System.out.println("1. Potion de vie standard : rends 2 points de vie ");
            System.out.println("2. Grande potion de vie : rends 5 points de vie");

            choix = scanner.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre une Potion ou une Grande potion");
            }
        }

        switch (choix) {
            case 1:
                life += 2;
                setPotion("Potion de vie standard");
                break;
            case 2:
                life += 5;
                setPotion("Grande potion de vie");
                break;
        }

        return life;
    }



    public String toString() {
        String weaponString = "Votre  arme" +  Weapon + "Votre Potions " + Potion ;
        return  weaponString;
    }
}
