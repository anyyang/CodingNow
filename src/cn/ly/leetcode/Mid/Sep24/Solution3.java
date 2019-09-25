package cn.ly.leetcode.Mid.Sep24;

public class Solution3 {

    public static void main(String args[]) {
        Solution3 sb = new Solution3();
        //  int[] temp = {1, 2, 3};
        // int[] temp = {3, 2,0, 2};
        // int[] temp = {0,0,3};
        int[] temp = {1, 1, 1};
        int[] x = sb.fraction(temp);
        System.out.println(x[0] + " " + x[1]);
    }

    public int[] fraction(int[] cont) {
        int[] result = new int[2];
        fenshu fs = null;
        for (int i = cont.length - 1; i > -1; i--) {
            if (fs == null) {
                fs = new fenshu(1, cont[i]);
            } else {
                if (!fs.flag) {
                    fs.reveser();
                }
                fs.add(cont[i]);
            }
        }
        fs.maxDivisor();
        result[0] = fs.z;
        result[1] = fs.m;
        return result;
    }

}

class fenshu {
    fenshu(int z, int m) {
        this.z = z;
        this.m = m;
    }

    boolean flag = true;
    int z;
    int m;

    void add(int a) {
        if (m == 1 && a != 0) {
            z = a * m + z;
        } else {
            if (a != 0) {
                z = a * m + 1;
            }
        }
        flag = false;
    }

    void reveser() {
        flag = true;
        int temp = this.z;
        this.z = this.m;
        this.m = temp;
    }

    public void maxDivisor() {
        //求出两个数字之间的小值
        int min = z < m ? z : m;
        int k = 0;
        for (int i = min; i >= 1; i--) {
            if (z % i == 0 && m % i == 0) {
                k = i;
                break;
            }
        }
        z=z/k;
        m=m/k;
    }
}
