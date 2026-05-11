import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    // ---------------------------------------------------------
    // Valid Sudoku
    // Time: O(1)
    // Space: O(1)
    // Check:
    // 1. Rows
    // 2. Columns
    // 3. 3x3 Sub-boxes
    // ---------------------------------------------------------
    public static boolean isValidSudoku(char[][] board) {

        // -----------------------------------------------------
        // Check Rows
        // -----------------------------------------------------
        for (int row = 0; row < 9; row++) {

            Set<Character> seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                // Skip empty cell
                if (board[row][i] == '.') {
                    continue;
                }

                // Duplicate found
                if (seen.contains(board[row][i])) {
                    return false;
                }

                seen.add(board[row][i]);
            }
        }

        // -----------------------------------------------------
        // Check Columns
        // -----------------------------------------------------
        for (int col = 0; col < 9; col++) {

            Set<Character> seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                // Skip empty cell
                if (board[i][col] == '.') {
                    continue;
                }

                // Duplicate found
                if (seen.contains(board[i][col])) {
                    return false;
                }

                seen.add(board[i][col]);
            }
        }

        // -----------------------------------------------------
        // Check 3x3 Sub-boxes
        // square = 0 to 8
        // -----------------------------------------------------
        for (int square = 0; square < 9; square++) {

            Set<Character> seen = new HashSet<>();

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    // Calculate row and column
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;

                    // Skip empty cell
                    if (board[row][col] == '.') {
                        continue;
                    }

                    // Duplicate found
                    if (seen.contains(board[row][col])) {
                        return false;
                    }

                    seen.add(board[row][col]);
                }
            }
        }

        // Sudoku is valid
        return true;
    }
}
