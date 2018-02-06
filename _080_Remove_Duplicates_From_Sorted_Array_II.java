package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveDuplicatesFromSortedArrayII
 * Creator : Edward
 * Description : 80. Remove Duplicates from Sorted Array II (Follow up for 26)
 */

public class _080_Remove_Duplicates_From_Sorted_Array_II {
    /**
     Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     Example:
     Given sorted array nums = [1,1,1,2,2,3],
     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

     Case : [1,1,1,2,2,3]
     1,1,2,2,3
         c
         i
     result : [1,1,2,2,3]

     题意：
        这道题是26题的拓展问题：当数组里的每个元素至多出现2次时会怎么样？

        例如：
        给一个数组nums = [1,1,1,2,2,3], 需要返回的长度为5，同时前五个元素需要是1，1，2，2，3。超出返回长度的数组元素可以是任意值。

     思路：
        这道题和26题的思路很像，依旧是用Two Pointers的方法解决。
        1.取两个指针count和i，开始时都在2的位置（因为最终的数组长度至少为2）
        2.判断条件：n[i] != n[count-2], 因为count之前的值是保证没有重复元素的
        3.当符合判断条件时，用n[count++] = n[i]来实现对n[count]的删除
        4.i每次循环都加1，count只有在符合判断条件时才加1
        5.当循环结束时，返回count的值

     复杂度：
        time: O(n)
        space: O(1)

     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count-2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
