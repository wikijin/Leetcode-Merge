package leetcode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : VerifyPreorderSequenceinBinarySearchTree
 * Creator : Edward
 * Description : 255. Verify Preorder Sequence in Binary Search Tree
 */
public class VerifyPreorderSequenceinBinarySearchTree {
    /**
     Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
     You may assume each number in the sequence is unique.
     
     Follow up:
     Could you do it using only constant space complexity?
     
          6
         / \
        1   8
       / \
      0   3
         / \
        2   5

     preorder : 6 1 0 3 2 5 8

     num : 8
     min : 6
     stack : 8

     题意：
     给了我们一个一维数组，让我们验证其是否为一个二叉搜索树的先序遍历出的顺序(Follow up要求空间复杂度为O(1))。
     
     思路：
     
     法一：
     Stack
     1，二叉搜索树BST的性质是左<根<右
     2，BST先序遍历序列的特点是降序的部分一定是向左走的，一旦开始升序说明开始向右走了，则上一个降序的点则限定了后面的数的最小值
     3，下面用例子说明
         10
        / \
       5   12
      / \
     2   6
     如这个例子，我们在10的位置是没有最小值限定的，然后降序走到5，依然没有最小值，降序走到2，依然没有
     然后开始升序了，遇到6，这时候之后的数字一定大于2，同时也大于5，所以最小值更新为之前遍历过的数中比当前数稍微小一点的那个数
     这里我们想到用一个栈来存储之前的路径，升序时就是将栈中元素不断pop出来直到栈顶大于当前数，而最小值就是最后一个pop出来的数
     最后再把当前数push进去
     对于降序的时候，直接向里面push就行了
     这样，序列无效的条件就是违反了这个最小值的限定
     复杂度：
     time : O(n)
     space : O(n)
     
     法二：
     Pointer(指针模拟栈)
     满足Follow up O(1)的要求
     1，思路同Stack方法
     2，用指针i标记栈顶
     3，指针i初始化为-1，这样栈第一个元素加入时，i++后不会超界
     复杂度：
     time : O(n)
     space : O(1)

     * @param preorder
     * @return
     */

    public boolean verifyPreorder(int[] preorder) { // 法一
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
    
    public boolean verifyPreorder1(int[] preorder) { // 法二
        int min = Integer.MIN_VALUE;
        i = -1;
        for (int num : preorder) {
            if (num < min) return false;
            while (i >= 0 && num > preorder[i]) {
            min = preorder[i--];
            }
            preorder[++i] = num;
        }
        return true;
    }
}
