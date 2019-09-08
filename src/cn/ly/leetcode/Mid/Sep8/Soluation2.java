package cn.ly.leetcode.Mid.Sep8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Soluation2 {


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
          int i=start;
          int j =destination;
          int result[] =new int[2];
          while (i!=j){
              if(i<distance.length){
                  i++;
              }else {
                  i=0;
                  continue;
              }
              if(i!=0){
                  result[0] +=distance[i-1];
              }else{
                  result[0] +=distance[distance.length-1];
              }


          }
        i=start;
        while (j!=i){
            if(j<distance.length){
                j++;
            }else {
              j=0;
              continue;
            }
            if(j!=0){
                result[1] +=distance[j-1];
            }else{
                result[1] +=distance[distance.length-1];
            }

        }

          return  Math.min(result[0],result[1]);
    }
    public static void main(String args[]) {
        Soluation2 s1 = new Soluation2();
        int distance[] = new int[]{1,2,3,4} ;
        System.out.println(s1.distanceBetweenBusStops(distance, 0, 3));

    }
}
