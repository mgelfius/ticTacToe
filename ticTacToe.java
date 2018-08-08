import java.util.Random;
import java.util.Scanner;

public class ticTacToe{

    static String[][] boardArray = new String[4][4];
    static player[] playerList = new player[2];

    public static void main(String args[]){
        init();
        playGame();
    }

    public static void init(){
        String[] botNames = new String[]{"Twiki", "Hal", "Artoo"};
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of human players");
        int playerCount = s.nextInt();
        s.nextLine();
        while(playerCount < 0 || playerCount > 2){
            System.out.println("Oops! Please enter a number between 0 and 2");
            playerCount = s.nextInt();
        }
        for(int i = 0; i < playerCount; ++i){
            System.out.println("Please enter name for player " + (i + 1));
            String playerName = s.nextLine();
            playerList[i] = new player(true, playerName);
        }
        if(playerCount < 2){
            for(int j = playerCount; j < 2; ++j){
                playerList[j] = new player(false, botNames[j]);
            }
        }
        buildBoardArray();
        printBoard();
    }

    public static void buildBoardArray(){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                boardArray[i][j] = " ";
            }
        }
    }

    public static void printBoard(){
        int j = 0;
        while(j < 3){
            for(int i = 1; i < 8; ++i){
                if(i%2 != 0){
                    System.out.print('|');
                }
                else if(boardArray[i/2 - 1][j] == " "){
                    System.out.print('_');
                }
                else{
                    System.out.print(boardArray[i/2 - 1][j]);
                }
            }
            System.out.println();
            ++j;
        }
    }

    public static void playGame(){
        boolean winner = false;
        String[] turn = new String[]{"X", "O"};
        int whoseTurn = new Random().nextInt(2);
        System.out.println(playerList[whoseTurn].getName() + " goes first");
        while(winner != true){
            if(playerList[whoseTurn].getHuman() == true){
             Scanner s = new Scanner(System.in).useDelimiter("\\s");
             System.out.println("Enter your pick as a row followed by a column. Example: 2 2");
                int row = s.nextInt();
                int column = s.nextInt();
                if(row > 0 && row <=3 && column > 0 && column <=3){
                    if(boardArray[column - 1][row - 1] == " "){
                     boardArray[column - 1][row - 1] = turn[whoseTurn];
                        if(whoseTurn == 0){
                            ++whoseTurn;
                        }else{
                            --whoseTurn;
                        }
                        printBoard();
                        System.out.println();
                    }else{
                        System.out.println("Nice try, bucko! Somebody's in that spot.");
                    }
                    if(checkWinner() == "X" || checkWinner() == "O" || checkWinner() == "Tie"){
                        winner = true;
                        s.close();
                    }
                }else{
                    System.out.println("Oops! That's not a proper coordinate.");
                }
            }else{
                int row = 2;
                int column = 2;
                while(boardArray[column][row] != " "){
                    row = new Random().nextInt(3);
                    column = new Random().nextInt(3);
                }
                boardArray[column][row] = turn[whoseTurn];
                if(whoseTurn == 0){
                    ++whoseTurn;
                }else{
                    --whoseTurn;
                }       
                printBoard();
                System.out.println();
                if(checkWinner() == "X" || checkWinner() == "O" || checkWinner() == "Tie"){
                    winner = true;
                }
            }
        }
        if(checkWinner() == "Tie"){
            System.out.println("It's a tie!");
        }
        else{
            if(checkWinner() == "X"){
                System.out.println(playerList[0].getName() + " is the winner!");
            }else
            if(checkWinner() == "O"){
                System.out.println(playerList[1].getName() + " is the winner!");
            }
           
        }
    }

    public static String checkWinner(){
        int counter = 0;
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(boardArray[i][j] == "X"){
                    ++counter;
                }else
                if(boardArray[i][j] == "O"){
                    counter += 4;
                }
            }
            if(counter == 3){
                return "X";
            }else
            if(counter == 12){
                return "O";
            }else{
                counter = 0;
            }
        }
        for(int j = 0; j < 3; ++j){
            for(int i = 0; i < 3; ++i){
                if(boardArray[i][j] == "X"){
                    ++counter;
                }else
                if(boardArray[i][j] == "O"){
                    counter += 4;
                }
            }
            if(counter == 3){
                return "X";
            }else
            if(counter == 12){
                return "O";
            }else{
                counter = 0;
            }
        }
        if((boardArray[0][0] == boardArray[1][1] && boardArray[0][0] == boardArray[2][2]) || (boardArray[0][2] == boardArray[1][1] && boardArray[0][2] == boardArray[2][0])){
            return boardArray[1][1];
        }
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(boardArray[i][j] == " "){
                    return null;
                }
            }
        }
        return "Tie";
    }

}