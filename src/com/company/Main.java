package com.company;

public class Main {
    static UserInput userInput = new UserInput();

    public static void main(String[] args) {
	// menu
        String username = "ludvig";
        String password = "789bog";
        JDBCWriter jdbcWriter = new JDBCWriter();
        boolean con = jdbcWriter.setConnection(username,password);
        UserInput userInput = new UserInput();
        LinkedList linkedlist = new LinkedList();
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
                    Player player;
                    player = createPlayer();
                    System.out.println(player.toString());
                    linkedlist.insertAtEnd(player);
                    System.out.println(linkedlist.toString());
                    linkedlist.countOfElements();
                    System.out.println(linkedlist.countOfElements());

                    break;
                case 2:
                    LinkedList list = jdbcWriter.returnAllPlayers();
                    list.show();
                    break;
                case 3:
                    System.out.println("Halløjsa");
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 9: //Luk
                    run = false;
                    break;
                default:
            }
        }
    }
    public static Player createPlayer(){
        String firstname = userInput.inputString("Input first name",true);
        String lastname = userInput.inputString("Input last name",true);
        int age = userInput.inputInt("Input age");
        int team = userInput.inputInt(1,2, "Input team");
        Player player = new Player(firstname, lastname, age, team);
        return player;

    }
}

