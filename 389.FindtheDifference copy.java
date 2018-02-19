题意：给你两个字符串s和t， t比s多一个字母，除了这个多的字母以外，剩下所有的字母都相同（位置可以不同），找出这个多余的字母。

思路：巧妙地运用异或操作，异或的原理为，都转换为二进制，当前位数字相同就为零，不同就为1. 这样我们一直异或下去，最后剩下的那个就是答案。

异或:  ^ (相同为零，不同为一)

0 0 0
0 1 1
1 0 1
1 1 0
     
异或举例：
4 : 0100
6 : 0110
    0010  
4 : 0100
    0110 ->6

复杂度：
time: O(n);
space: O(1);
   

class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
