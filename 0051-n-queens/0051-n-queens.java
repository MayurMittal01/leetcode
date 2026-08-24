import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans);

        return ans;
    }

    public void solve(int row, char[][] board, List<List<String>> ans) {

        if (row == board.length) {
            List<String> temp = new ArrayList<>();

            int i = 0;
            while (i < board.length) {
                temp.add(new String(board[i]));
                i++;
            }

            ans.add(temp);
            return;
        }

        int col = 0;

        while (col < board.length) {

            if (isSafe(row, col, board)) {

                board[row][col] = 'Q';

                solve(row + 1, board, ans);

                board[row][col] = '.';
            }

            col++;
        }
    }

    public boolean isSafe(int row, int col, char[][] board) {

        int i;
        int j;

        i = row - 1;

        while (i >= 0) {
            if (board[i][col] == 'Q') {
                return false;
            }
            i--;
        }

        i = row - 1;
        j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}