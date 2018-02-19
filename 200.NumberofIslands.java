

题意：给一个01矩阵，求不同的岛屿的个数。0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。注意： 我们只考虑上下左右为相邻。

思路：1.非常重要的一道题，可以用dfs也可以用bfs（dfs更常用）
     2.dfs解法：（1）遍历数组，如果遇到1，就进入helper function， 进去找相邻的岛。
            （2）进入到helper function以后，第一个注意越界，第二个避免重复访问（访问过的变为零），直至周围全部是0（无岛可寻）
     3.bfs解法：（1）与dfs相似，但是要注意，bfs要用的数据结构是queue，找到一个1，丢入queue，这里用到一个小技巧，queue里面可以存x * m + y，来巧妙地保存坐标。
            （2）进入到bfs的函数以后，同样要注意越界与避免重复访问，与dfs不同的是，（1）终止条件为queue为空 （2）在当前节点分别查找四个方向，如果是1，果断丢进queue

     4.这两个方法的区别：dfs是顺着一个方向找到底，不碰棺材不回头，bfs则是，我只顾着我当前节点能看到的四个点，一层层向外拓张势力。


复杂度：
time : O(m * n)
space : O(n)

     * @param grid
     * @return
     */

class Solution {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

     

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}
    

复杂度：
 time : O(m * n)
 space : O(m * n)
 * @param grid
 * @param i
 * @param j
 */

    
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer((i * m) + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1') {
                queue.offer((i * m) + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}

