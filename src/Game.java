import java.util.Random;

public class Game {

    private int D1;
    private int D2;
    int round = 0;

    public int getD1() {
        return D1;
    }

    public void setD1(int D1) {
        this.D1 = D1;
    }

    public int getD2() {
        return D2;
    }

    public void setD2(int D2) {
        this.D2 = D2;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Game() {
        int position = 0;

        // ---------------------------   Character   ----------------------------- //
        Warrior warrior = new Warrior();
        warrior.character();  // nom du perso
        warrior.CharacterType(warrior.getName()); // choix guerrier ou magicien


        do {
            System.out.println("  ");
            round++; // compte le nombre de tour

            Menu menu = new Menu();
            String updateName =  menu.playOrUpdate(warrior.getName());
            warrior.setCharacterName(updateName);


            //   -----------------------------   lancer des D ---------------------------------- // ---   Position Perso --- //
            System.out.println("***************      Tour n° " + round + "     *************** ");
            System.out.println("  ");
            Random r = new Random();
            D1 = r.nextInt(6) + 1;
            D2 = r.nextInt(6) + 1;
            System.out.println("lancer =>  D1 : " + D1 + "  D2 : " + D2);
            int totalD = D1 + D2;
            System.out.println("total : " + totalD);


            // ---------------------------------   Position Perso -------------------------------//
            position += totalD;

            System.out.println("Tu est sur la case  n° " + position);

            // ---------------------------------  double D ---------------------------------- //

//            Warrior warrior = new Warrior();
//            int updateAttack = warrior.warrior(D1, D2, character.getAttack(), round);
//            character.setAttack(updateAttack);

//            int nbRound = 0;
//            nbRound--;
//            Warrior warrior = new Warrior();
//            warrior.warrior(D1, D2, character.getAttack(), nbRound);

            // ------------------------------  print info joueur ---------------------------- //

            Weapon weapon = new Weapon();
            warrior.characterInfo(warrior.getName(), warrior.getCharacterRole(), warrior.getLife(), warrior.getAttack(), weapon.getWeapon(), weapon.getPotion() );
            //weapon.infoEquipement();

            //System.out.println("Votre  arme : " + weapon.getWeapon() +" Votre Potions : " +  weapon.getPotion());

            //System.out.println(weapon.toString());

            //System.out.println(character.toString());
//
            // ------------------------------   offensive   -------------------------------- //

            if (warrior.getCharacterRole().equals("Guerrier")){
               int updateWeapon =  weapon.warriorWeapon(warrior.getAttack());
               warrior.setAttack(updateWeapon);
            }

            Spell spell = new Spell();

            if(warrior.getCharacterRole().equals("Magicien")){
                int updateWeapon = spell.spellMagician(warrior.getAttack());
                warrior.setAttack(updateWeapon);
            }

            int updatePotions = weapon.potions(warrior.getLife());
            warrior.setLife(updatePotions);


            // **********************************  fin du jeu *************************************** //

            // --------------------------  vie a 0 --------------------------------//
            if (warrior.getLife() == 0){

                System.out.println("  ");
                System.out.println("******  Votre personnage est mort fin du jeux !!!  ******");
                break; // Sorti de la boucle
            }
        // ---------------------------------- sortie du plateau ---------------------------------------//
            if (position >= 64) {
                System.out.println("  ");
                System.out.println("******  Le personnage a atteint la fin du jeux !!!  ******");
                break; // Sorti de la boucle
            }

            System.out.println("  ");

        } while (true);
    }
}





