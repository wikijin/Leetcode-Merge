package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MaximumProductofWordLengths
 * Creator : Edward
 * Description : 318. Maximum Product of Word Lengths
 */
public class MaximumProductofWordLengths {
  
      Given a string array words, find the maximum value of length(word[i]) * length(word[j])
      where the two words do not share common letters. You may assume that each word will contain only lower case letters.
      If no such two words exist, return 0.

     Example 1:
     Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
     Return 16
     The two words can be "abcw", "xtfn".

     Example 2:
     Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
     Return 4
     The two words can be "ab", "cd".

     Example 3:
     Given ["a", "aa", "aaa", "aaaa"]
     Return 0
     No such pair of words.

     题意： 给一个string array， 找出这个array当中的最长的两个element长度的乘积，期中，这两个element必须满足没有重复的元素。

     思路： 1. 用位操作
           2. val |= 1 << (words[i].charAt(j) - 'a'); 这个操作实现了把当前这个char标为1. （哪个字母出现了就标为1）

              val |= 1 << (words[i].charAt(j) - 'a');

             1 << 0  00001 = 1  a （a出现，右侧第一位标为1）
             1 << 1  00010 = 2  b  (b出现过，右侧第二位标为1)
             1 << 2  00100 = 4  c
             1 << 3  01000 = 8

            abc = 00111 = 7   ab = 00011 = 3

            3. bytes[i] & bytes[j] == 0 这个操作是检查这两个string是否有重复字母，如果有的话，那么当前位1 & 1的结果是 1，只有第一个string出现或者第二个string出现结果都为0.

    
    复杂度：
     time : O(n^2)
     space : O(n)

     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
