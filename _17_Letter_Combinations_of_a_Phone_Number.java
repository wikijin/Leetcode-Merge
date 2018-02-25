package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LetterCombinationsofaPhoneNumber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsofaPhoneNumber {
    /**
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    Example:
    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


    题意：

    根据手机按钮的排列，按照其数字到字母的映射，给定一个数字字符串，返回这些数字可以表示的所有的字母组合
    例子：input为数字字符串 “23”
    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

    思路：
    典型的backtracking题。另一种写法是用for循环，但这种写法的适用条件非常苛刻，可能其他大部分题目并不适用，但面试中如果不让用backtracking，可以用这种方法。

    backtracking解法： letterCombinations
    1，进行helper函数backtracking调用
    2，先建立一个String[]来代表数字到字母的映射，数字就是0，1，2... 等等index
    3，用for循环来处理一个数字代替的所有字母，依次递归回溯
    4，何时加入结果：当index等于数字字符串的长度的时候，加入结果

    for循环解法： letterCombinations2
    1，用linkedlist实现queue，遵循先进先出的原则
    2, 用暂时的res的peek的length是否等于当下的index来实现了一个queue的bfs的解法
  

复杂度：
     time : O(3^n)
     space : O(n);
         
    * @param digits
    * @return 
    */


    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }

    public void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
    }

}