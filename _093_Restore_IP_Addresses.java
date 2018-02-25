package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : helperAddresses
 * Creator : Edward
 * Date : Dec, 2017
 * Descrstion : 93. Restore IP Addresses
 */
public class RestoreIPAddresses {
    /**
     
    Given a string containing only digits, restore it by returning all possible valid s address combinations.
    
    For example:
    Given "25525511135",
    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    
题意：
    输入一个数字字符串，还原成合理的ip地址，要求输出所有的可能性。（ps: ip地址要求是按照每个区间值在1-255之间，且只能有3个点的一串数字）

思路：
    最传统的backtracking的解法
    1，用count来判断一共有几段，合理的ip地址只能有4段；当index到了字符串最后且count等于4的时候，则为合理的ip地址，加入最终返回结果
    2，ip每一段首数字不可以是零，所以如果第一个数字是零或者这一段的数字大于255，则不是合理地址，不用进入dfs
    3，用变量 i 来遍历当前位置和当前位置后1-2位的组合是否合理，如果合理，则进入dfs

复杂度：
    time : O(3^4) => O(1) => O(3^n)
    space : O(n)
     
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }
    public void helper(List<String> res, String s, int index, String ret, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256)) continue;
            helper(res, s, index + i, ret + temp + (count == 3 ? "" : "."), count + 1);
        }
    }
}