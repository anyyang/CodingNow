public class Main {
    class Super {
        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }

    class Sub extends Super {
        int flag = 1;
        Sub(int i) {
           // 此处隐藏调用了。 super();
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);

        }

        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }

    public static void main(String[] args) {
        new Main().new Sub(5);
    }
}

