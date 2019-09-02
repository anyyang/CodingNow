package cn.ly.leetcode.Mid;


public class TestDemo {
    public static String output ="";
    public static String foo(int i){
        try{
            if(i == 1){
                throw new Exception();
            }
        }catch(Exception e){
            output += "2";
            return output ;
        }finally{
            output += "3";
        }
        output += "4";

        return output;
    }

    public static void main(String[] args) {
        System.out.println( foo(0));
        System.out.println(  foo(1));
        System.out.println(output);
    }
}
