package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NestedListWeightSumII
 * Creator : Edward
 * Date : Aug, 2017
 * Description : 364. Nested List Weight Sum II
 */
public class NestedListWeightSumII {
    /**
    Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
    Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
    Example 1:
    Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
    Example 2:
    Given the list [1,[4,[6]]], return 17.
    (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
    
题意：
    这道题是339 Nested List Weight Sum I 的拓展，不同的是，这道题的深度越深，权重越小，和339刚好相反，最后同样要求返回嵌套链表权重累加值

思路：
    仍然使用dfs，但与之前不同的是，这道题在不知道最深深度的时候是无法一步计算的；但是可以利用递归调用的特点，从最外层的元素开始遍历，每次进入下一层，
    将最外层元素再代入计算一次，即一共有几层，最外层元素就被计算了几次。每一层的result变量不断累加下一层返回回来的累加值。
    bfs解法是一样的思路，但是用queue来实现。

复杂度：
    time : O(n);
    space : O(n);
    
     * @param nestedList
     * @return
     */
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new LinkedList<>();
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger();
            } else {
                nextList.addAll(nest.getList());
            }
        }
        res += nextList.isEmpty() ? 0 : helper(nextList, res);
        return res;
    }

    //bfs
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = 0;
        int res = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    sum += nest.getInteger();
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            res += sum;
            nestedList = nextList;
        }
        return res;
    }
}