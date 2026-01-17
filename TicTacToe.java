/*
 *ICS4U - Midterm Project
 * Name: Min Khant Thaw
 * 2D Tic-Tac-Toe (3x3 Board)
 */
import java.util.Scanner;
public class TicTacToe {

    //Instance variables
    private char [] [] board;
    private int whoseturn;
    private String [] players;
    private char [] pieces = {'X', 'O'};

    // Constructor
    public TicTacToe(String player1, String player2){
        board = new char [4][4];
        players = new String [2];
        players[0] = player1;
        players[1] = player2;
        whoseturn = 0;

        // Initialize board with '_'
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                board[i][j] = '_';
            }
        }
    }

    //Checks if move is within bounds
    public boolean inbounds(int row, int column){
        return row >=1 && row <=3 && column >=1 && column <= 3;
    }

    //Places that current player's piece on the board
    public boolean Move (int row, int column){
        if (!inbounds(row,column)){
            System.out.println("ERROR: THE MOVE IS OUT OF BOUNDS!");
            return false;
        }
        else if (board[row][column] != '_'){
            System.out.println("ERROR: POSITION IS ALREADY OCCUPIED!");
            return false;
        }
        board[row][column] = pieces[whoseturn];
        whoseturn = (whoseturn + 1) % 2;
        return true;
    }


    //Prints the board with row and column labels
    public void printBoard(){
        System.out.print("  "); // to print top-left blank space

        //To print column labels
        for (int p = 1; p <=3; p++){
            System.out.print(p + " ");
        }
        System.out.println();

        //To print row labels
        for (int b = 1; b <= 3; b++){
            System.out.print(b + " ");
            for (int m = 1; m <= 3; m++){
                System.out.print(board[b][m] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Simulation part
    public static void main(String[] args){
        System.out.println("--WELCOME TO TIC-TAC-TOE GAME--");
        Scanner scanner = new Scanner (System.in);

        //To input players' names
        System.out.print("Enter Player 1's name for (X): ");
        String p1 = scanner.nextLine();

        System.out.print("Enter Player 2's name for (O): ");
        String p2 = scanner.nextLine();

        TicTacToe game = new TicTacToe(p1, p2);

        game.printBoard(); //print initial board

        // Simulate two turns (4 valid moves)
        for (int i = 0; i < 4; i++){
            System.out.println(game.players[game.whoseturn] + ", who plays for (" + game.pieces[game.whoseturn] + ")");

            System.out.print("Please enter row (1-3): ");
            int row = scanner.nextInt();

            System.out.println("Please enter column (1-3): ");
            int column = scanner.nextInt();

            if (game.Move(row,column)){
                game.printBoard();
            } else {
                game.printBoard(); // show board again
                i--;
            }
        }
        scanner.close();
    }


}