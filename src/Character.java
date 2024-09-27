import java.util.Scanner;

abstract class Character {

    private String characterRole;
    private String characterName;

    int life;
    int attack;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getCharacterRole() {
        return characterRole;
    }

    public void setCharacterRole(String characterRole) {
        this.characterRole = characterRole;
    }

    public String getName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    // nom du perso
    public void character() {


        Scanner obj = new Scanner(System.in);

        System.out.println("Choisissez un nom pour votre personnage : ");

        characterName = obj.nextLine();

    }

    // choix du type de perso et attribuer la vie et l'attaque en fonction
    public void CharacterType(String characterPseudo) {
        characterName = characterPseudo;

        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        while (choix != 1 && choix != 2) {
            System.out.println("  ");
            System.out.println("************************************************************");
            System.out.println("Choisissez un personnage " + characterPseudo + ":");
            System.out.println(" 1. Guerrier ");
            System.out.println(" 2. Magicien ");
            System.out.println("************************************************************");
            System.out.println("  ");


            choix = scanner.nextInt();

            if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez choisir entre un Guerrier ou un Magicien");
            }
        }

        switch (choix) {
            case 1:
                characterRole = "Guerrier";
                break;
            case 2:
                characterRole = "Magicien";
                break;
            default:
                characterRole = "Personnage non reconnu.";
        }

        System.out.println("Le personnage choisi est " + characterPseudo + " le " + characterRole);


        if (characterRole.equals("Guerrier")) {
            life = 10;
            attack = 10;
            System.out.println("Niveau de vie : " + life);
            System.out.println("attack : " + attack);

        } else if (characterRole.equals("Magicien")) {
            life = 6;
            attack = 15;
            System.out.println("Niveau de vie : " + life);
            System.out.println("Force  : " + attack);
        } else {
            System.out.println("Personnage non reconnu.");
        }
    }


    public void characterInfo(String name, String role, int life, int attack, String Weapon, String Potion) {

        System.out.println("Personnage :  " + name);
        System.out.println("Role : " + role);
        System.out.println("Niveau de vie : " + life);
        System.out.println("Force  : " + attack);
        System.out.println( "Votre  arme : " +  Weapon);
        System.out.println( "Votre Potions : " + Potion);
    }


    public String toString() {
        return "Personnage : " + characterName  + " role :" + characterRole + "Niveau de vie : " + life + "Force :" + attack;
    }


}
