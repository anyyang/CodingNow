package cn.ly.leetcode.Mid.Sep24;

/**
 * Created by  liuyang
 * 2019/9/24    17:28
 * cn.ly.leetcode.Mid.Sep24
 * All Right Reserved by liuyang.
 **/

public class Solution {
    public String replaceSpace(StringBuffer str) {
        char[] arraychar = str.toString().toCharArray();
        String result = "";
        for(int i = 0 ;i < arraychar.length; i++){
            if(arraychar[i]==' '){
                result += "%20";
            }else{
                result += arraychar[i];
            }
        }
        return result;
    }
}