
题意：
    这道题定义了一种嵌套链表的结构，链表可以无限往里嵌套，规定每嵌套一层，权重加1，求总权重之和。
    意思就是将就是每个数字乘以其权重，再求总和。
    例子：数组 [[1,1],2,[1,1]] 返回10； 数组 [1,[4,[6]]] 返回27

思路：
    dfs：
    1，遍历给的嵌套链表的数组，每个嵌套链表对象调用dfs函数，每次递归权重加1
    2，在dfs函数中，如果当下元素是嵌套链表，遍历链表，其中包含的每个链表再一次调用dfs函数；如果直接是整数，则返回当前深度乘以整数
    3，最后dfs函数中每一层都将返回值累加起来返回即可

    bfs 解法：
    1，用Queue<NestedInteger>实现bfs
    2，如果当前元素是整数，直接放入queue，并且累加result变量
    3，如果当前元素是嵌套链表，则将链表中的所有元素（包括整数和链表）全部放入queue中
    4，每一层权重变量加1
    5，最后queue中只有整数不再包含嵌套，result变量直接累加完毕即可

    linkedlist实现bfs
    1，用linkedlist代替queue，思路和bfs相同，每次将更新的linkedlist放入循环中

复杂度：
    time : O(n)
    space : O(n);


class Solution{
   // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            } else {
                res += helper(nest.getList(), depth + 1);
            }
        }
        return res;
    }
}

class Solution{
    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    queue.addAll(nest.getList());
                }
            }
            depth++;
        }
        return res;
    }    
}


class Solution{
    // LinkedList
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        while (nestedList.size() != 0) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            depth++;
            nestedList = nextList;
        }
        return res;
    }
}