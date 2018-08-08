import java.util.Scanner;

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
        System.out.println("X goes first");
        String[] turn = new String[]{"X", "O"};
        int whoseTurn = 0;
        while(winner != true){
            Scanner s = new Scanner(System.in).useDelimiter("\\s");
            System.out.println("Enter your pick as a row followed by a column. Example: 2 2");
            int row = s.nextInt();
            int column = s.nextInt();
            if(boardArray[column][row] == " "){
                boardArray[column][row] = turn[whoseTurn];
                if(whoseTurn == 0){
                    ++whoseTurn;
                }else{
                    --whoseTurn;
                }
                printBoard();
            }else{
                System.out.println("Nice try, bucko! Somebody's in that spot.");
            }
            if(checkWinner() == "X" || checkWinner() == "O"){
                winner = true;
                s.close();
            }
        }
    }

    public static String checkWinner(){
        
        return null;
    }
}