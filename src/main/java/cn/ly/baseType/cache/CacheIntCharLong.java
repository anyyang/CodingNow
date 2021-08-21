package cn.ly.baseType.cache;

public class CacheIntCharLong {
    public static void main(String[] args) {

        //缓冲池只缓冲-128-127之间的数字，所以这里的第二行等于是重新new了一个Integer对象
        Integer a = 129;
        Integer b = 129;
        System.out.println(a==b);

        //直接赋值取的是缓冲池中的值所以 就是相等的。因为内存地址也一样
        Integer i = 12;
        Integer j = 12;
        System.out.println(i==j);

        // new 相当于创建了一个新的对象 所以这个堆里的和缓存里的不相等也没问题
        Long m = 126L;
        Long n = new Long(126);
        System.out.println(m==n);

        // new 相当于创建了一个新的对象 所以这个堆里的和缓存里的不相等也没问题
        Long q = 126L;
        Long w = 126L;
        System.out.println(q==w);
    }
}
