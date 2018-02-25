package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WallsandGates
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 286. Walls and Gates
 */
public class WallsandGates {
    /**
     * 

     You are given a m x n 2D grid initialized with these three possible values.
     -1 - A wall or an obstacle.
     0 - A gate.
     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume
     that the distance to a gate is less than 2147483647.
     Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
     it should be filled with INF.
     For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0  -1 INF INF
     After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4
    
题意: 
    墙和门
    给一个2D矩阵，其中有三种可能的数值：-1表示墙，0表示门，INF表示空房间，让求每个空房间到们的最短path，其中-1不可以走，需要绕过
    如果从空房间不能到达任意的门，那么这个空房间位置的数字设为INF
    
思路： 
    和number of islands 很像，有dfs和bfs两种解法
    从门开始找，找可以到达的房间

dfs解法：
    1.用dfs函数实现dfs，主函数当中用两个for循环遍历所有位置，当当下位置为门（gate）的时候进入dfs函数
    2.边界条件 -> 当下row和col出了2d矩阵的边框，或者当下空房间里面已经填过的距离比正在计算的距离要小，则不需要更新，不需要进入dfs

bfs解法：
    1.用queue<int[]>来实现bfs,int[]里面装的就是x,y坐标，主程序不变，如果当下元素是门，则放入queue
    2.将临近的INF空房间的数字update加一 然后将临近元素的坐标放入queue当中

复杂度：
     time : O(m * n)
     space : O(m * n)
     
     * @param rooms
     */

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dis) return;
        rooms[i][j] = dis;
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }


//bfs解法
    public void wallsAndGates2(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}