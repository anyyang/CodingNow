package cn.ly.java.excepiton;

/**
 * @author : liuyang
 * @date : 2020/5/30 17:00
 * email : liu.yang@autoyong.com
 **/
public class ExceptionAndFinally {
    public static void main(String[] args) {
        ExceptionAndFinally    ea= new ExceptionAndFinally();
        System.out.println(ea.throwMe());
    }

    public String throwMe(){
        try{
            throw new RuntimeException("000000");
        }catch (Exception e){
            System.out.println("111111111111");
            e.printStackTrace();
            throw e;
        }
        finally {
           System.out.println("but i am fine");
            return "hello this is test";
        }
    }

}
