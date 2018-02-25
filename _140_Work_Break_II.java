

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WordBreakII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 140. Word Break II
 */
public class WordBreakII {
    /**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

题意： 
	这道题是139 word break的拓展，要求返回所有的可能分解组合。

思路：
	仍然用dfs来写
	1，建立一个hashmap，key是当前的index，value是这个以这个index为起点，后面所有字母可以分解成为的所有单词
	2，用dfs里面的index变量和一个end指针来截取substring，如果当前的substring可以在dictionary里面找到，则以end为起点再次调用dfs函数
	3，每次backtracking到index 0 的时候，res加上所有map当中存下的以后面index为key的所有words. 然后继续移动end指针，找其他可能分解组合

复杂度：	
 	time : O(n^3)
    space : O(n^3)
     * @param s
     * @param wordDict
     * @return
     */

    HashMap<Integer, List<String>> map = new HashMap<>();

    // DFS
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public List<String> dfs(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDict, end);
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}