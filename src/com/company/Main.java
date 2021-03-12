package com.company;

public class Main {

    public static void main(String[] args) {
	// menu
        UserInput userInput = new UserInput();
        JDBCWriter jdbcWriter = new JDBCWriter();
        boolean run = true;
        int menuChoice;
        String headertext = "Fodbold club??";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuitems = {"1. create new player", "2. list all players",
                "3. search for a player","4. delete a player", "5. search for players", "9. Exit"};

        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice){
                case 1:
                    Player player = new Player();
                    player.createPlayer();
                    System.out.println(player.toString());
                    break;
                case 2:
                    System.out.println("Davs");
                    break;
                case 3:
                    System.out.println("Halløjsa");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    // Connect to db LAV DET HER OM TIL LOGIN ?
                    String username = userInput.inputString("Please enter username",false);
                    String password = userInput.inputString("Please enter password",false);
                    boolean con = jdbcWriter.setConnection(username,password);

                case 9: //Luk
                    run = false;
                    break;
                default:
            }
        }
    }
}
