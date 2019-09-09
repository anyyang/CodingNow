package cn.ly.leetcode.Mid.Sep3.ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  liuyang
 * 2019/9/3    13:30
 * cn.ly.leetcode.Mid.Sep3.ByteDance
 * All Right Reserved by liuyang.
 * 1234
 **/

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        char[] charArray =  s.toCharArray();



        return result;
    }

    public static void main(String args[]) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> lists = restoreIpAddresses.restoreIpAddresses("123456");
        lists.forEach(s -> System.out.println(s));
    }


}
