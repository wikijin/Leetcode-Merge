package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SingleNumber
 * Creator : Edward
 * Description : 136. Single Number
 */
public class SingleNumber {
   
     Given an array of integers, every element appears twice except for one. Find that single one.

     题意：给你一个integer的array，有且只有一个元素仅出现过一次，剩下每一个元素都出现过两次。找出那个只出现过一次的元素。

     思路：当遇到这种一大群element出现过两次，只有一个出现过一次的情况，就要考虑运用异或。异或的原理为，表示为二进制时，相同为零，不同为一。
          遍历整个数组，对每一个元素都进行异或操作，最后剩下的结果就是那个single element
     
     ^ : 异或 : 相同为0，不同为1
     1 1 : 0
     0 0 : 0
     1 0 : 1
     0 1 : 1
    
    复杂度： 
    time : O(n) space : O(1)
     
    * @param nums
    * @return
    */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
