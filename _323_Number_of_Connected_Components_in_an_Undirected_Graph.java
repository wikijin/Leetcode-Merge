/**
 * Created by Junyan Zhang on 1/29/2018.
 */
public class _323_Number_of_Connected_Components_in_an_Undirected_Graph {
    /*

     Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     write a function to find the number of connected components in an undirected graph.
     Example 1:
     0          3
     |          |
     1 --- 2    4
     Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
     Example 2:
     0           4
     |           |
     1 --- 2 --- 3
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
     Note:
     You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
     [0, 1] is the same as [1, 0] and thus will not appear together in edges.

     题意：
        用0 ~ n-1表示n个节点，每一对数组表示两个点之间存在一条无向边，写一个函数查找图中包含多少个联通区域


     思路：
        Union Find（并查集）
            新建一个n大小的数组并全部初始化为-1。定义find函数：roots[i]表示节点i所指向的节点，每调用一次find函数，相当于向上
            查找目前已知的该节点的根节点。res表示，当前联通的区域的数量，初始值为n。用find函数找到当前边起点的根节点是x，终点
            对应根节点是y，如果x和y不相等，说明这两个区域当前不联通，并且添加上x->y这条边后，两个区域可以变为联通区域（res--）。
            于是把这条边用roots[x] = y来加入，并且res--。

     复杂度：
        time : O(edges * nodes)
        space : O(n)

     */

    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }

}
