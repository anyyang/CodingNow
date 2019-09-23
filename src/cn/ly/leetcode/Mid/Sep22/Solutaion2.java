package cn.ly.leetcode.Mid.Sep22;

/**
 * https://leetcode-cn.com/contest/weekly-contest-155/problems/ugly-number-iii/
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。

 丑数是可以被 a 或 b 或 c 整除的 正整数。

 示例 1：
 输入：n = 3, a = 2, b = 3, c = 5
 输出：4
 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 示例 2：

 输入：n = 4, a = 2, b = 3, c = 4
 输出：6
 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 示例 3：

 输入：n = 5, a = 2, b = 11, c = 13
 输出：10
 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 示例 4：

 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 输出：1999999984
 */
public class Solutaion2 {
    public int nthUglyNumber(int n,int a, int b, int c) {
        if (n <= 0) {
            return 0;
        }
        int result = 1;
        int r1 = 1;
        int r2 = 1;
        int r3 = 1;
        int count=0;
        while(count<=n){
            int multiply2 = r1 * a;
            int multiply3 = r2 * b;
            int multiply5 = r3 * c;
            int min = Math.min(multiply2,Math.min(multiply3,multiply5));
            result = min;
            if (multiply2 == min) {
                ++count;
                r1++;
            }
            if (multiply3 == min) {
                ++count;
                r2++;
            }
            if (multiply5 == min) {
                ++count;
                r3++;
            }
        }
        return result;
    }
    public static void main(String args[]){
      Solutaion2  s2= new Solutaion2();
      s2.nthUglyNumber(3,2,3,5);
    }
}
