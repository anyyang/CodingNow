package cn.ly.leetcode.Mid.Sep1;
//反转负数
class Solution {
    public int reverse(int x) {
        //负数标识位
        boolean flag = true;
        if(x<0){
            x=0-x;
            flag =false;
        }
        String temp = ""+x;
        char[] numchar = temp.toCharArray();
        temp ="";
        for(int i = 1 ; i <= numchar.length; i++)
        {
            temp += numchar[numchar.length - i];
        }
        try{
            int result = Integer.parseInt(temp);
            if(!flag){
                result = 0 - result;
            }
            return result;
        }catch(Exception e){
            return 0;
        }

    }
}