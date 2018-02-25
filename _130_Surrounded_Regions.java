package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SurroundedRegions
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 130. Surrounded Regions
 */
public class SurroundedRegions {

    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     A region is captured by flipping all 'O's into 'X's in that surrounded region.
     For example,
     X X X X
     X O O X
     X X O X
     X O X X
     After running your function, the board should be:
     X X X X
     X X X X
     X X X X
     X O X X

题意：
    给一个二维的矩阵，包含 'X' 和 'O', 将所有四面被'X'包围的'O'，并用 'X' 填充满，其他'O'不变


思路：
    如何确认'O'是否被X包围：所有边界上的'O'都是不被X包围的，而且，尤这些边界'O'向四周扩展找到的'O'也是不被'X'包围的
    所以从边界出发，找到边界上的'O'，并找到相连的'O',将这些元素都临时修改为‘1’
    最后遍历方格中的所有元素，如果是O，则修改为X；如果为1，则恢复为O。
    dfs解法：用helper函数实现向四周扩展的不断递归
    bfs解法：用queue和wrapper函数实现，先找到边界所有的'O'放入queue里面，再将相邻的'O'都放入queue中，同时将queue中的位置都设为'1'

复杂度：
    time : O(m * n)
    space : O(n)
    

     * @param board
     */

    //dfs解法
    public void solve(char[][] board){
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length - 1;
        int n = board[0].length - 1;

        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n] == 'O') {
                dfs(board, i, n);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m][i] == 'O') {
                dfs(board, m, i);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }

    
    class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    //bfs解法
    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length - 1;
        int n = board[0].length - 1;
        Queue<Point> queue = new LinkedList<>();

        //get all 'O's on the edge first
        for (int r = 0; r <= m; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = '1';
                queue.add(new Point(r, 0));
            }
            if (board[r][n] == 'O') {
                board[r][n] = '1';
                queue.add(new Point(r, n));
            }
        }

        for (int i = 0; i < n; i++){
            if (board[0][i] == 'O') {
                board[0][i] = '1';
                queue.add(new Point(0, i));
            }
            if (board[m][i] == 'O') {
                board[m][i] = '1';
                queue.add(new Point(m, i));
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '1';
                queue.add(new Point(row - 1, col));
            }
            if (row + 1 < m && board[row + 1][col] == 'O') {
                board[row + 1][col] = '1'; queue.add(new Point(row + 1, col));
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '1';
                queue.add(new Point(row, col - 1));
            }
            if (col + 1 < n && board[row][col + 1] == 'O') {
                board[row][col + 1] = '1';
                queue.add(new Point(row, col + 1));
            }
        }
        
        for (int i = 0; i<= m; i++){
            for (int j=0; j<= n; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

}