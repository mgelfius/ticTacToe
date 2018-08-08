public class ticTacToe{

    public static void main(String args[]){
        printBoard();
    }

    public static void printBoard(){
        int j = 0;
        while(j < 3){
            for(int i = 0; i < 7; ++i){
                if(i%2 == 0){
                    System.out.print('|');
                }
                else{
                    System.out.print('_');
                }
            }
            System.out.println();
            ++j;
        }
    }
}