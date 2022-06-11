package cn.ly.leetcode.Mid.Jun11;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个正序数组的中位数
 *给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ArrayDemo {

    public static void main(String[] args) {
        //Solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        Solution2.myAtoi("1");
    }
}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] dd = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, dd, 0, nums1.length);
        System.arraycopy(nums2, 0, dd, nums1.length, nums2.length);
        Arrays.sort(dd);
        if(dd.length%2==0){
            int index = dd.length /2-1 ;
            int next = index +1;
            double result  =((double)dd[index]+(double)dd[next])/2;
            return  result;
        }else {
            int index = dd.length /2 ;
            return   dd[index];

        }
    }
}

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution2 {
    public  static int myAtoi(String s) {
        String result = s.trim();
        if(s==null ||  (s.trim()).equals("")){
            return 0;
        }
        if(s.length()==1){
            s = s.replaceAll("[^(0-9)]", "");
            if(s.equals("")){
                return 0;
            }
            return Integer.parseInt(s);
        }

        char[] array = s.toCharArray();
        String numStr="";
        char lastChar = ' ';
        boolean numStart =  false;
        for(int i=0 ;i <array.length ;i++){

            if (Character.isDigit(array[i])) {
                numStart=true;
                // 把字符串转换为字符， 再调用
                //  Character.isDigit(char) 方法判断是否是数字
                numStr+=array[i];
            }else{
                if(numStart){
                    break;
                }
                if(array[i]=='-'){
                    lastChar= '-';
                }else{
                    lastChar=' ';
                }
            }
        }
        Long num = Long.parseLong((lastChar+numStr).trim());
        if(num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(""+num);
    }
}