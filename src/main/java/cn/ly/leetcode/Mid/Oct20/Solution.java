package cn.ly.leetcode.Mid.Oct20;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<3){
            return true;
        }
        double basetan = Double.MIN_VALUE;
        int basex= Math.abs(coordinates[0][0]);
        int basey= Math.abs(coordinates[0][1]);
        for (int i = 1; i <coordinates.length ; i++) {

           int x= Math.abs(coordinates[i][0]);
           int y= Math.abs(coordinates[i][1]);
           double tan = 0;
           int tempx = Math.abs(x-basex);
           int tempy =  Math.abs(y-basey);
           double temptan = 0;
           if(tempy!=0){
               temptan =tempx/tempy;
           }else if(tempx==0){
               temptan=0;
           }
           if(i==1){
               basetan = temptan;
           }else{
               if(basetan != temptan){
                   return false;
               }
           }
        }
        return true;
    }
    public static void main(String args[]){
      //  int[][] myList = {(1,2),(2,3),(3,4),(5,6)};
      Solution so = new Solution();
      //boolean re= so.checkStraightLine(myList);
       // System.out.println(re);
    }
}
