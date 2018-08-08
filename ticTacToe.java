import java.util.Random;
import java.util.Scanner;

//TODO: Play computer
//TODO: Choose which player goes first

public class ticTacToe{

    static String[][] boardArray = new String[4][4];

    public static void main(String args[]){
        buildBoardArray();
        printBoard();
        playGame();
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
        System.out.println(turn[whoseTurn] + " goes first");
        while(winner != true){
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
        }
        if(checkWinner() == "Tie"){
            System.out.println("It's a tie!");
        }
        else{
            System.out.println(checkWinner() + " is the winner!");
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