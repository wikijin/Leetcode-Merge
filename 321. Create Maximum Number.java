题意：
    给出两个长度分别是m和n的数组来表示两个大整数，数组的每个元素都是数字0-9。从这两个数组当中选出k个数字来创建一个最大数，其中k满足
    k <= m + n。选出来的数字在创建的最大数里面的位置必须和在原数组内的相对位置一致。返回k个数的数组。你应该尽可能的去优化算法的时间
    复杂度和空间复杂度。

思路：
    1. 从nums1里取i个元素组成最大数组，从nums2里取k-i个元素组成最大数组。
    2. 合并之前结果，得到一个长度为k的最大数组。
    3. 对于不同长度分配的情况，比较每次得到的长度为k的最大数组，返回最大的一个。

参考讲解：
    https://segmentfault.com/a/1190000007655603

复杂度：
    time: O((m+n)^3) 不确定
    space: O(k)


class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(temp, 0, res, 0)) {
                res = temp;
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i > k - j && j > 0 && nums[i] > res[j - 1]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}