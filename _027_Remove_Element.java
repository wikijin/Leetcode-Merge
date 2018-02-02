package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveElement
 * Creator : Edward
 * Description : 27. Remove Element (Related problems: 26, 80)
 */

public class _027_Remove_Element {
    /**
     Given an array and a value, remove all instances of that value in place and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.
     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example:
     Given input array nums = [3,2,2,3], val = 3
     Your function should return length = 2, with the first two elements of nums being 2.

     Case: [3,2,2,3] 3
     2,2
     r
     i
     res : [2,2]

     题意：
        给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
        元素的顺序可以改变，并且对新的数组不会有影响。

     思路：
        这是一道Two Pointers问题，用快慢指针解决。
        1.取两个指针，一开始都在0的位置
        2.快指针每次循环都加1，慢指针只有在符合判断条件时才加1
        3.判断条件：快指针所指向的值不等于val
        4.当快指针扫完数组时，返回慢指针的值

     复杂度：
        time : O(n);
        space : O(1);

     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
