package cn.ly.leetcode.Mid.Sep2.ByteDance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by  liuyang
 * 2019/9/2    13:55
 * cn.ly.leetcode.Mid.Sep2.ByteDance
 * All Right Reserved by liuyang.
 **/

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 */

public class LengthOfLongestSubstring {
    /**
     * 思路找出所有不重复字符串长度。把最大长度保存下来。
     * 找不重复字符串的原理就是 ，如果出现重复元素，则下次循环时候，
     * 开始元素l 指向第一个重复元素后的节点
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringDaLao(String s) {
        //  重复元素的下一个元素 。
        int l = 0;
        //保存的最大值
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String strtemp = s.substring(l, i);
            int num = strtemp.indexOf(s.charAt(i));
            if (num != -1) {
                l = s.indexOf(s.charAt(i), l) + 1;
            }
            result = Math.max(result, i - l + 1);
        }
        return result;
    }

    /**
     * 如果有重复，找到重复的下一位开始重新循环。
     *    1 2 3 5 4 5 6 7 8 9 1 2 3 4 5
     *             ↑        ↑
     *          start        i
     *          start始终指向重复元素后的第一个元素
     *          i始终向后移动
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int maxlength = 0;
        int start = 0;
        for (int i = 0; i < s.length() ; i++) {
            //这是句最关键的一步  从重复元素的下一个节点开始继续截取最长字符串
            String temp =  s.substring(start, i);
            // 这个是向右移动的i箭头
            char mychar = s.charAt(i);
            //查找当前i元素是否存在这个截取段内，如果不存在，长度+1；
            //如果存在
            int index = temp.indexOf(mychar);
            //说明不存在
            if (index == -1) {
                //不存在就增加截取长度
                length = temp.length() + 1;
            } else {
                //  如果区间内存在重复， 那么现在mychar这个字符是重复的
                //从重复的下一位开始，继续寻找最长字符串
                start = s.indexOf(mychar, start) + 1;
                length = 1;
            }
            maxlength = length > maxlength ? length : maxlength;
        }
        return maxlength;
    }

    public static void main(String args[]) {
        LengthOfLongestSubstring sub = new LengthOfLongestSubstring();
        //    int su = sub.lengthOfLongestSubstring("1234556789123456789");
        //   System.out.println(su);
        System.out.println("--------------");
        int su2 = sub.lengthOfLongestSubstring("dvdf");
        System.out.println(su2);
    }
}
