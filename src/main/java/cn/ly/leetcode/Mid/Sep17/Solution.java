package cn.ly.leetcode.Mid.Sep17;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by  liuyang
 * 2019/9/17    14:14
 * cn.ly.leetcode.Mid.Sep17
 * All Right Reserved by liuyang.
 **/

/**
 * https://leetcode-cn.com/contest/weekly-contest-154/problems/maximum-number-of-balloons/
 * 1189. “气球” 的最大数量 显示英文描述
 * 用户通过次数812
 * 用户尝试次数835
 * 通过次数822
 * 提交次数1326
 * 题目难度Easy
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] array = new int[5];
        char[] result = text.toCharArray();
        if (result.length < 5) {
            return 0;
        }
        for (int i = 0; i < result.length; i++) {
            switch (result[i]) {
                case 'b':
                    array[0]++;
                    break;
                case 'a':
                    array[1]++;
                    break;
                case 'l':
                    array[2]++;
                    break;
                case 'o':
                    array[3]++;
                    break;
                case 'n':
                    array[4]++;
                    break;
                default:
                    break;
            }
        }
        array[2] = (int) Math.floor(array[2] / 2);
        array[3] = (int) Math.floor(array[3] / 2);
        Arrays.sort(array);
        return array[0];
    }
}
