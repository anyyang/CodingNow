package cn.ly.leetcode.Mid.Sep22;

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
