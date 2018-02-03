题意：
	假设你和n个人在一个聚会中（标记为0到n-1），其中可能存在一个名人。
	名人的定义是：所有其他n-1个人都认识他/她，但他/她不认识其中任何一个人。

	现在你想要找到这个名人，或者验证出这个名人不存在。要想知道A是否认识B，你唯一可以做的就是询问问题：“你好，A，请问你认识B吗？”。你需要尽可能少地询问（以渐进的方式）这个问题来找出名人（或者验证其不存在）。

	你将得到一个辅助函数bool knows(a, b)，它会告诉你A是否知道B.实现一个函数 int findCelebrity(n)，你的函数应该使 knows 的调用次数最少。

	注意：
	如果名人存在的话，只会有一个。
	名人如果存在，请返回名人的索引数，否则返回-1。

思路：
	1.首先判断特殊情况，当n < 2的时候名人一定是不存在的
	2.假设名人存在于0的位置，设为possible
	3.从1遍历剩下的n-1个人，如果knows(possible, i)为真，说明possible不是名人，于是将i的值付给possible
	4.遍历一遍后得到的possible值只能保证possible不认识它之后出现的任何人，所以还需要再遍历一遍确认possible是名人，否则就返回-1
	5.第二次遍历的判断条件是：当possible不是i这个人时，如果possible认识i，或者i不认识possible，则说明possible不是名人

复杂度：
	time: O(n)
	space: O(1)

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
      
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (possible != i && (knows(possible, i) || !knows(i, possible))) {
                return -1;
            }
        }
        return possible;
    }
}