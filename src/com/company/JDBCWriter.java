package com.company;

import java.sql.*;

public class JDBCWriter {

    private static Connection connection = null;

    public boolean setConnection(String username, String password) {

        final String url = "jdbc:mysql://127.0.0.1:3306/kailuacarrental?serverTimezone=UTC";
        boolean bres = false;

        try {
            connection = DriverManager.getConnection(url, username, password);
            bres = true;
            if (bres) {
                System.out.println("Connection status: " + bres);
            }
        } catch (SQLException error) {
            System.out.println("\nNo connection made");
        }
        return bres;
    }

    public int deleteMember(int id){

        String delStr = "DELETE FROM players WHERE player_id = ?";
        PreparedStatement preparedStatement;
        int result = -1;

        try{
            preparedStatement = connection.prepareStatement(delStr);
            preparedStatement.setInt(1,id); //Kig i første kolunne og brug parameter til at vælge
            result = preparedStatement.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fejl i deleteMember");
        }

    return result;
    }

    //vi sender et player objekt til metoden, og den indsætter den.
    public int insertPlayer(Player player){

        String insStr = "INSERT INTO players(first_name,last_name,age,team) VALUES ('" +
                player.getFirstname() + "','" +
                player.getLastname() + "'," +
                player.getAge() + "," +
                player.getTeam() + ")";
        PreparedStatement preparedStatement;

        int result = -1;

        try{
            preparedStatement = connection.prepareStatement(insStr);
            int rowcount = preparedStatement.executeUpdate();
            result = rowcount;

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQL fejl i insertPlayer");
        }

        System.out.println("Successfully inserted a player");
    return result;
    }

    public Player getPlayerFromDbById(int player_id){

        String selectStr = "SELECT * FROM players where player_id = ?";
        PreparedStatement preparedStatement;
        Player player = new Player();

        try {
            preparedStatement = connection.prepareStatement(selectStr);
            preparedStatement.setInt(1,player_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            //vi bruger executeQuery

            while (resultSet.next()){
                int playerid =resultSet.getInt("player_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int team = resultSet.getInt("team");

                player.setFirstname(first_name);
                player.setLastname(last_name);
                player.setAge(age);
                player.setTeam(team);

                // LAV MIG player.setPlayer_ID(playerid);
            }

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fejl i getPlayerFromDbById");
        }

    return player;
    }


    public int updatePlayer(int player_id, Player player){

    return 1;}

}
