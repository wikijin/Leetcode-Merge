

题意：
    运用 加，减，和乘法，输出给定数字字符串所有可能的运算来得到目标值的搭配方式。
    例子： "123", 6 -> ["1+2+3", "1*2*3"] 

思路：
    典型的 dfs backtracking + 枚举
    1，当计算结果等于目标值，且所有数字都用完的时候，则是有效结果，dfs结束
    2，加法和减法可以直接正常处理，但乘号的时候，由于乘法有优先运算，所以需要用一个变量记录在当下做乘法之前
       前面已经计入计算但现在需要被加上或者被减掉的数字
    3，要处理截取的数字有连续零的情况，leading的数字有一个零是可以的，如果有连续多个零，说明截取的位置已经不对，不需要再进入dfs
    4，起始位置需要单独处理，因为起始位置不能加运算符号

复杂度：
    time : 不知道
    space : O(n)
     
class Solution{
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String path, String num, int target, int pos, long val, long pre) {
        if (pos == num.length()) {
            if (target == val) {
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, val - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }
}
