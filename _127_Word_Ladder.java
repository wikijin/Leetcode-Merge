package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GeneralizedAbbreviation
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 320. Generalized Abbreviation
 */
public class GeneralizedAbbreviation {
    /**
     * 
    Write a function to generate the generalized abbreviations of a word.
    example：
    Given word = "word", return the following list (order does not matter):
    ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]

题意
    给定一个字符串，求出所有化简的形式：比如可以将当前字母化简为1，或者将当前两个字母化简为2，以此类推

思路
    用backtracking
    helper函数有两种情况：当遍历到当前字母的时候，
    第一种情况是：保留当前字母不变，加到当前字符串当中，将之前的字符串用count简化兑现，插入这个count数字，然后再加上当前的字母
    第二种情况是：将当前字母变成包含到count里面，变成数字，则count + 1
    遍历到字符串最后的时候，需要检查当前count是否为零，如果不是，则需要在结果中加上count

复杂度：
     time : O(2^n)
     space : O(n) (不确定)
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    public void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        } else {
            helper(res, word, pos + 1, cur, count + 1);
            helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }

    }

}