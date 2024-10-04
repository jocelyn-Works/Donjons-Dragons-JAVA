package fr.campus.dandd.Db;

import fr.campus.dandd.Character.Character;
import fr.campus.dandd.Character.Warrior;
import fr.campus.dandd.Character.Wizard;

import java.sql.*;

public class Db {


    private final String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String username = "root";
    private final String password = "jojo291295";
    private Connection con;


    public Db() {
        getConnection();
    }

    public void getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Connexion Echoué");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
    }


    public void getAllHero() {

        String query = "SELECT * FROM hero";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String player_type = rs.getString("player_type");
                String playerName = rs.getString("player_name");
                int life = rs.getInt("life");
                int attack = rs.getInt("attack");
                String weapon = rs.getString("weapon");


                System.out.println(id + " =>  " + player_type + " , Nom: " + playerName + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon);


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Character createHero(String role, String name, int life, int attack) {
        String query = "INSERT INTO hero ( player_type, player_name, life, attack) VALUES (  ?, ?, ?, ?)";

        Character player = null;

        try {
            PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, role);
            stmt.setString(2, name);
            stmt.setInt(3, life);
            stmt.setInt(4, attack);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);  // Récupère l'ID généré
            }
            if (role.equals("Guerrier")) {

                player = new Warrior();
                player.setId(generatedId);
                player.setCharacterName(name);
                player.setCharacterRole(role);
                player.setLife(life);
                player.setAttack(attack);

            } else if (role.equals("Magicien")) {

                player = new Wizard();
                player.setId(generatedId);
                player.setCharacterName(name);
                player.setCharacterRole(role);
                player.setLife(life);
                player.setAttack(attack);

            } else {
                System.out.println("Erreur  dans l' Atribution du personnage ( createHero )");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return player;
    }


    public Character getOneHero(int playerId) {
        String query = "SELECT * FROM hero WHERE id = " + playerId;

        Character player = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);



            if (res.next()) {
                // data player
                String player_type = res.getString("player_type");
                String player_name = res.getString("player_name");
                int life = res.getInt("life");
                int attack = res.getInt("attack");
                String weapon = res.getString("weapon");

                System.out.println("    ");
                System.out.println(" Votre Choix  => " + player_type + " , Nom: " + player_name + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon);
                System.out.println("     ");

                if (player_type.equals("Guerrier")) {
                    player = new Warrior();
                    player.setId(playerId);  // Utilise l'ID passé en paramètre
                    player.setCharacterName(player_name);
                    player.setCharacterRole(player_type);
                    player.setLife(life);
                    player.setAttack(attack);

                } else if (player_type.equals("Magicien")) {
                    player = new Wizard();
                    player.setId(playerId);  // Utilise l'ID passé en paramètre
                    player.setCharacterName(player_name);
                    player.setCharacterRole(player_type);
                    player.setLife(life);
                    player.setAttack(attack);

                } else {
                    System.out.println("Erreur dans l'attribution du personnage (getOneHero)");
                }

            } else {
                System.out.println("Aucun personnage trouvé avec l'ID " + playerId);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return player;
    }





    public Character updatePlayerName(String name, int playerId) {
        String query = "UPDATE hero SET player_name = ? WHERE id = ?";
        Character player = null;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, playerId);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return player;

    }

    public void updateTypeHero(String role, int life, int attack, int playerId) {
        String query = "UPDATE  hero SET player_type = ? , life = ? , attack = ?  WHERE id = ?";


        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, role);
            stmt.setInt(2, life);
            stmt.setInt(3, attack);
            stmt.setInt(4, playerId);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public int updatelifeHero(int life, int playerId) {
        String query = "UPDATE  hero SET life = ? WHERE id = ?";



        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, life);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return life;
    }

    public int updateAtackHero(int attack, int playerId) {
        String query = "UPDATE  hero SET attack = ? WHERE id = ?";


        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, attack);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return attack;
    }

    public String updateWeaponnHero(String weapon, int playerId) {
        String query = "UPDATE  hero SET weapon = ? WHERE id = ?";


        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, weapon);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return weapon;
    }

    public String updatePotionHero(String potion, int playerId) {
        String query = "UPDATE  hero SET potion = ? WHERE id = ?";


        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, potion);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return potion;
    }


}
