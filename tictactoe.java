import java.util.Scanner;
1
public class tictactoe
 {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args)
     {
        initializeBoard();
        displayBoard();

        while (!isGameOver()) {
            takeTurn();
            displayBoard();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        char winner = checkWinner();
        if (winner == ' ') {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }

    private static void initializeBoard()
     {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard()
     {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void takeTurn()
     {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row and column (e.g., 0 0): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                takeTurn();
            } else {
                board[row][col] = currentPlayer;
            }
        }
    }

    private static boolean isGameOver()
     {
        return isBoardFull() || checkWinner() != ' ';
    }

    private static boolean isBoardFull() 
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                 {
                    return false;
                }
            }
        }
        return true;
    }

    private static char checkWinner()
     {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') 
            {
                return board[i][0];
            }
            // Check columns
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
             {
                return board[0][i];
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
         {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') 
        {
            return board[0][2];
        }
        // No winner yet
        return ' ';
    }
}
