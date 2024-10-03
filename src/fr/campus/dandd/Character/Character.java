package fr.campus.dandd.Character;

public abstract class Character {

    private String characterRole;
    private String characterName;

      int life;
      int attack;

    public Character(String characterName, String characterRole) {

        this.characterName = characterName;
        this.characterRole = characterRole;

    }

    public  int getLife() {
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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }




    public String toString() {
        return "   Personnage : " + characterName + "\n" + "   Role :" + characterRole + "\n"+ "   Niveau de vie : " + life+ "\n" + "   Force : " + attack;
    }


}
