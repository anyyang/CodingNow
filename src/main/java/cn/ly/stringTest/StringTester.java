package cn.ly.stringTest;

public class StringTester {

    public static void main(String[] args) {
        StringTester st = new StringTester();
        st.checkStringAddress1();
        st.checkStringAddress2();
    }

    // Java8中的字符串常量池在Metaspace中
    //java8 intern方法说明：
    // 如果字符串常量池中  字符串哈希表中 没有该字符串引用。
    // 则把堆中引用地址复制到 字符串常量池中的hashtable
    // 如果字符串常量池中 字符串哈希表中 有该字符串的引用
    // 则直接返回该字符串在常量池中的引用
    private void checkStringAddress1() {
        String s1 = "haha";
        String s2 = new String("haha");
        System.out.println(s1 == s2);
        System.out.println(s1 == s2.intern());
    }

    private void checkStringAddress2() {
        String s1 = new String("haha");
        String s2 = new String("ha") + new String("ha");
        System.out.println(s1 == s2.intern());
        //证明 s2.intern返回的是 ”haha“的字符串引用
        System.out.println("haha" == s2.intern());
    }
}
