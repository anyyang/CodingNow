package cn.ly.leetcode.Mid.Sep8;

public class Soluation3 {
    public int maximumSum(int[] arr) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
            sum += arr[i];



        }
       return result;
    }

    public static void main(String args[]) {
        int a[] = new int[]{1, -2, 0, 3};
        Soluation3 s3 = new Soluation3();
        int re = s3.maximumSum(a);
        System.out.println(re);
    }
}
