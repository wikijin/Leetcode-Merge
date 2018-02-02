/**
 * Created by Junyan Zhang on 1/31/2018.
 */
public class _265_Paint_House_II {
    /**
     There are a row of n houses, each house can be painted with one of the k colors.
     The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.
     The cost of painting each house with a certain color is represented by a n x k cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color 0;
     costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
     Note:
     All costs are positive integers.

    题意：
        有一排房子，每一栋房子可以被刷成k种颜色，刷每种颜色的成本也各不相同。你需要把所有房子刷上油漆，
        相邻的两座房子不能有相同的颜色，刷每座房子的成本表示为一个n x k的矩阵。例如，cost[0][0]是把0号房子刷成红色
        的成本；cost[1][2]是把1号房子刷成绿色的成本，等等。请找到给所有房子涂上油漆的最小成本。


    思路：
        类似于Paint House，但是变成了k种颜色，贪心法就可以了，每座房子找最便宜的颜色刷，如果最便宜的颜色跟上一座相同，那就找第二便宜的，
        于是内层循环就变成了找数组最小跟第二小的两个元素问题。

    复杂度：
        time : O(n * k)
        space : O(1)


     */

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;

        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }
}
