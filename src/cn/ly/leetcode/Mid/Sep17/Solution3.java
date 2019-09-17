package cn.ly.leetcode.Mid.Sep17;

import java.util.Stack;

/**
 * Created by  liuyang
 * 2019/9/17    15:18
 * cn.ly.leetcode.Mid.Sep17
 * All Right Reserved by liuyang.
 **/

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution3 {
    /**
     * （）
     * 利用栈的数据结构解决
     */
    public void reverseString(char[] s) {
        Stack<Character> s1 = new Stack<Character>();
        for (int i = 0; i < s.length; i++) {
            s1.push(s[i]);
        }
        int count = 0;
        while (!s1.isEmpty()) {
            s[count] = s1.pop();
            count++;
        }
    }

    /**
     *
     * 左右指针交换着来
     * @param s
     */
    public void reverseString2(char[] s) {
        if (s.length > 1) {
            int left = 0;
            int right = s.length - 1;
            boolean flag = true;
            while (flag) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left ++;
                right --;
                if(left>= right){
                    flag = false; //结束条件
                }
            }
        }
    }
}