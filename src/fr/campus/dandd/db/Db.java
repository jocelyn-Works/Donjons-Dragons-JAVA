package fr.campus.dandd.db;

import fr.campus.dandd.character.Character;
import fr.campus.dandd.character.Warrior;
import fr.campus.dandd.character.Wizard;

import java.sql.*;

public class Db {


    private final String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String username = "root";
    private final String password = "jojo291295";
    private Connection con;

    /**
     * desc : instacie la connection lors de lappel de la classe Db
     */
    public Db() {
        createDataBase();
        getConnection();
    }

    /**
     *  crée la base de donné et la table hero avec 2 personnage
     */
    public void createDataBase() {
        Connection con = null;
        Statement stmt = null;

        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/";  // URL sans spécifier de base de données
        String username = "root";  // Nom d'utilisateur MySQL
        String password = "jojo291295";  // Mot de passe MySQL
        String driverName = "com.mysql.cj.jdbc.Driver";  // Driver MySQL

        try {

            Class.forName(driverName);


            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            String sqlCreateDB = "CREATE DATABASE IF NOT EXISTS DonjonsEtDragons";
            stmt.executeUpdate(sqlCreateDB);
            System.out.println("Base de données 'DonjonsEtDragons' créée avec succès.");


            con = DriverManager.getConnection(url + "DonjonsEtDragons", username, password);
            stmt = con.createStatement();


            DatabaseMetaData dbMetaData = con.getMetaData();
            ResultSet tables = dbMetaData.getTables(null, null, "hero", null);

            if (!tables.next()) {

                String sqlCreateTable = "CREATE TABLE hero (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "player_type VARCHAR(100), " +
                        "player_name VARCHAR(50), " +
                        "life INT, " +
                        "attack INT, " +
                        "weapon VARCHAR(50), " +
                        "potion VARCHAR(50)" +
                        ")";
                stmt.executeUpdate(sqlCreateTable);
                System.out.println("Table 'hero' créée avec succès.");


                String insertGuerrier = "INSERT INTO hero (player_type, player_name, life, attack) VALUES ('Guerrier', 'Guerrier', 10, 10)";
                String insertMagicien = "INSERT INTO hero (player_type, player_name, life, attack) VALUES ('Magicien', 'Magicien', 6, 15)";
                stmt.executeUpdate(insertGuerrier);
                stmt.executeUpdate(insertMagicien);

                System.out.println("Personnages de base (Guerrier et Magicien) insérés avec succès.");
            } else {
                System.out.println("La table 'hero' existe déjà. Aucune insertion supplémentaire n'a été effectuée.");
            }

        } catch (SQLException ex) {
            System.out.println("Échec de la connexion ou de la création : " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC non trouvé : " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la fermeture des ressources : " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }




    /**
     * desc : Connection a la Base de Donné
     */
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

    /**
     * desc : Récupére tous les utilisateurs de la table hero
     */
    public void getAllHero() {

        String query = "SELECT * FROM hero";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String player_type = rs.getString("player_type");
                String playerName = rs.getString("player_name");
                int life = rs.getInt("life");
                int attack = rs.getInt("attack");
                String weapon = rs.getString("weapon");
                String potion = rs.getString("potion");


                System.out.println(id + " =>  " + player_type + " , Nom: " + playerName + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon + " , Potion : " + potion);


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * desc : Crée un perssonnage en bdd
     * @param role
     * @param name
     * @param life
     * @param attack
     * @return
     */
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


    /**
     *  desc : récupére un perssonnage en BDD grace a son ID
     * @param playerId
     * @return
     */
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
                String potion = res.getString("potion");

                System.out.println("    ");
                System.out.println(" Votre Choix  => " + player_type + " , Nom: " + player_name + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon + " , Potion : " + potion);
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


    /**
     *  desc : Modifie le Nom du perssonnage
     * @param name
     * @param playerId
     * @return
     */
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

    /**
     *  desc : Modifie le rôle du perssonnage en lui réattribuant ses attributs en fonction du choix
     * @param role
     * @param life
     * @param attack
     * @param playerId
     */
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

    /**
     * desc : Modifie la vie du perssonnage BDD
     * @param life
     * @param playerId
     * @return la vie mise a jour
     */
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

    /**
     * desc : Modifie l'attaque du perssonnage BDD
     * @param attack
     * @param playerId
     * @return l' Attaque  mise a jour
     */
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

    /**
     *  desc : Modifie l' Arme du pessonnage
     * @param weapon
     * @param playerId
     * @return  l' Arme mise a jour
     */
    public String updateWeaponnHero(String weapon, int playerId) {
        String query = "UPDATE  hero SET weapon = ? WHERE id = ?";


        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, weapon);
            stmt.setInt(2, playerId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return weapon;
    }


    /**
     *  desc : Modifie la Potion du perssonnage en BDD
     * @param potion
     * @param playerId
     * @return  la Potion mise a jour
     */
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
