package cn.ly.leetcode.Mid.Sep8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * https://leetcode-cn.com/contest/weekly-contest-153/problems/distance-between-bus-stops/
 * 5181. 公交站间的距离 显示英文描述
 * 题目难度Easy
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
 * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class Soluation2 {


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int j = destination;
        int result[] = new int[2];
        while (i != j) {
            if (i < distance.length) {
                i++;
            } else {
                i = 0;
                continue;
            }
            if (i != 0) {
                result[0] += distance[i - 1];
            } else {
                result[0] += distance[distance.length - 1];
            }


        }
        i = start;
        while (j != i) {
            if (j < distance.length) {
                j++;
            } else {
                j = 0;
                continue;
            }
            if (j != 0) {
                result[1] += distance[j - 1];
            } else {
                result[1] += distance[distance.length - 1];
            }

        }

        return Math.min(result[0], result[1]);
    }

    public static void main(String args[]) {
        Soluation2 s1 = new Soluation2();
        int distance[] = new int[]{1, 2, 3, 4};
        System.out.println(s1.distanceBetweenBusStops(distance, 0, 3));

    }
}
