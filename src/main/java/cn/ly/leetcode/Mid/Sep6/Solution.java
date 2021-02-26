package cn.ly.leetcode.Mid.Sep6;

public class Solution {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String args[]) {
        Solution so = new Solution();

        String str = so.longestPalindrome("ccc");
        System.out.println(str);
    }

    public String longestPalindrome(String s) {

        int result[] = new int[2];
        char arrays[] = s.toCharArray();
        for (int i = 0; i < arrays.length; i++) {
            int left = i;
            int right = left + 1;
            //   abccba   完全对称情况  以cc 为中心向两侧延申  <--  cc   -->
            while (left >= 0 && right < arrays.length && arrays[left] == arrays[right]) {
                left--;
                right++;
            }
            if (right - left > result[1] - result[0]) {
                result[0] = left;
                result[1] = right;
                //   System.out.println("1.x=" + x + " y=" + y);
            }
            left = i - 1;
            right = i + 1;
            // abcdcba   有对称轴的对称      以d为中心向两侧延申    <-- d   -->
            while (left >=0 && right < arrays.length && arrays[left] == arrays[right]) {
                left--;
                right++;
            }
            if (right - left > result[1] - result[0]) {
                result[0] = left;
                result[1] = right;
                //  System.out.println("2.x=" + x + " y=" + y);
            }

        }
        return s.substring(result[0] + 1, result[1]);
    }


}
