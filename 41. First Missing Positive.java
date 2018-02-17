题意：
	给出一个无序的整数数组，找出其中没有出现的最小正整数。
	你的算法应该耗费O(n)的时间复杂度和O(1)的空间复杂度。

思路：
	这道题目用Bucket Sort（桶排序）的思想做：
	1. 桶排序的中心思想是“对应位置放对应的东西”，这里对应的概念就是：每一个index位置应放的正整数应该是index + 1
	2. 首先遍历一遍数组，如果nums[i]的值是正整数(nums[i] > 0)且小于等于nums的长度（index应当对应的正整数最大为nums.length），
	同时nums[nums[i] - 1] != nums[i]时，就交换nums[nums[i] - 1]和nums[i]的值
	3. 关于nums[nums[i] - 1] != nums[i]的解释：nums[i] - 1是nums[i]理论上应该所在的index位置（每一个index位置应放的正整数
	应该是index + 1），因此如果nums[nums[i] - 1]所对应的值不等于nums[i]，就应当交换他们以满足“对应位置放对应东西”。应当注意这
	里是while循环而不是if条件，因为有可能需要交换不止一次才能满足对应位置放对应东西
	4. 一次循环之后还需要再次循环nums，以检查数组中第一个出现的index对应的值不等于index + 1的地方，如果存在，就返回index + 1，否
	则就说明整个数组nums都是"对应位置放对应东西"，返回nums.length + 1即可

复杂度：
	time: O(n)
	space: O(1)


class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 1;
        
        for (int i = 0 ; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}