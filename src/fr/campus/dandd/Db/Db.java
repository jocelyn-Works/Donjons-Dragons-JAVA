package fr.campus.dandd.Db;

import fr.campus.dandd.Character.Character;

import java.sql.*;

public class Db {

    private final String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String username = "root";
    private final String password = "jojo291295";
    private Connection con;

    String player_type;
    String player_name;
    int life;
    int attack;

    public Db() {
        getConnection();
    }

    public void  getConnection() {
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

    Character player = null;

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


                System.out.println( id + " => Role : " + player_type + " , Nom: " + playerName + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getOneHero(int id) {
        String query = "SELECT INTO hero (id , player_type) VALUES (?, ?)";

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }




    public void createHero(String role, String name, int life, int attack) {
        String query = "INSERT INTO hero (player_type, player_name, life, attack) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, role);
            pstmt.setString(2, name);
            pstmt.setInt(3, life);
            pstmt.setInt(4, attack);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void editNameHero( String name) {
        String query = "UPDATE hero SET player_name = ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void ediTypeHero( String role) {
        String query = "UPDATE  hero SET player_type = ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, role);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }




}
