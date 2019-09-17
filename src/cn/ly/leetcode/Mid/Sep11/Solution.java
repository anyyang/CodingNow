package cn.ly.leetcode.Mid.Sep11;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by  liuyang
 * 2019/9/11    9:37
 * cn.ly.leetcode.Mid.Sep11
 * All Right Reserved by liuyang.
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() < 3 || numRows > s.length()) {
            return s;
        }
        ArrayList<ArrayList<Character>> resultList = new ArrayList<>(numRows);
        for (int j = 0; j < numRows; j++) {
            resultList.add(new ArrayList<Character>());
        }
        char[] arrays = s.toCharArray();
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < arrays.length; i++) {
            int listindex = i % (numRows);
            //获取到要添加的列表
            if (i > (i * numRows) && flag) {

            }


        }

        for (int j = 0; j < resultList.size(); j++) {
            ArrayList<Character> subList = resultList.get(j);
            subList.stream().forEach(sub -> System.out.print(sub.toString()));
            System.out.println();
        }
        return "";
    }

    public static void main(String args[]) {
       // LocalDateTime   time = new LocalDateTime();
        Solution solution = new Solution();
        solution.convert("LEETCODEISHIRING", 3);
    }
}
