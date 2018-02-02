package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveDuplicatesFromSortedArray
 * Creator : Edward
 * Description : 26. Remove Duplicates from Sorted Array
 */

public class _026_Remove_Duplicates_From_Sorted_Array {
    /**
     Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.

     Example:
     Given input array nums = [1,1,2],
     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

     Case : [1,1,2,2,3,4,5,6]
     1,2,3,4,5,6
       c
       i
     res : [1,2,3,4,5,6]

     题意：
        给一个排序数组，在原地删除数组里的重复元素，使得每一个元素只出现一次。

     思路：
        这是一道Two Pointers的题目，用快慢指针解决。
        1.取两个指针count和i，开始时都在1的位置（因为最终的数组长度至少为1）
        2.判断条件：n[i] != n[count-1], 因为count之前的值是保证没有重复元素的（这里也可以写成n[i] != n[i-1]）
        3.当符合判断条件时，用n[count++] = n[i]来实现对n[count]的删除
        4.i每次循环都加1，count只有在符合判断条件时才加1
        5.当循环结束时，返回count的值

     复杂度：
        time : O(n)
        space : O(1)

     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
