package fr.campus.dandd.Db;

import java.sql.*;

public class Db {

    private  final String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
    private final  String driverName = "com.mysql.cj.jdbc.Driver";
    private  final String username = "root";
    private  final String password = "jojo291295";
    private  Connection con;



    public  Connection getConnection() {
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
        return con;
    }

    public void getAllHero(){

        String query = "SELECT * FROM hero";
        try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(rs);

            while (rs.next()) {

                int id = rs.getInt("id");
                String player_type = rs.getString("player_type");
                String playerName = rs.getString("player_name");
                int life = rs.getInt("life");
                int attack = rs.getInt("attack");
                String weapon = rs.getString("weapon");


                System.out.println("ID : "  + id + " , Role : "+player_type + " , Nom: " + playerName + " , life :" + life + " , Attack : " + attack + " , Arme : " + weapon);
            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }


}
