package cn.ly.leetcode.Mid.Mar31;

import java.util.ArrayList;
import java.util.List;

/**
 * f(i,j) = f() +f()
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list =new ArrayList<>();
        for(int i=0;i<numRows;i++){ //每行的个数
            if(i==0){
                List<Integer> templist =new ArrayList<Integer>();
                templist.add(1);
                list.add(templist);
            }else{
                List<Integer> templist =new ArrayList<Integer>();
                for(int j=0;j<i+1;j++){
                    if(j==0||j==i){
                        templist.add(1);
                    }else{
                        List<Integer>  shangyihang =list.get(i-1);
                        templist.add(shangyihang.get(j-1)+shangyihang.get(j));
                    }

                }
                list.add(templist);
            }
        }

        return list;
    }
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list =new ArrayList<>();
        if(numRows==0){
            return list;
        }
        if(numRows==1){
            list.add(new ArrayList<Integer>());
            list.get(0).add(1);
            return list;
        }
        list = generate2(numRows-1);
        List<Integer> shangyihang = list.get(numRows-2);
        List<Integer> temp =new ArrayList<Integer>();
        temp.add(1); //第一位是1
        for(int i=1;i<numRows-1;i++){
            temp.add(shangyihang.get(i-1)+shangyihang.get(i));
        }
        temp.add(1);//最后一位是1
        list.add(temp);
        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list =new ArrayList<>();
        if(rowIndex==0){
            return list;
        }
        if(rowIndex==1){

            list.add(1);
            return list;
        }
        list = getRow(rowIndex-1);
        List<Integer> temp =new ArrayList<Integer>();
        temp.add(1); //第一位是1
        for(int i=1;i<rowIndex-1;i++){
            temp.add(list.get(i-1)+list.get(i));
        }
        temp.add(1);//最后一位是1
        return temp;
    }
    public static void main(String[] args) {
        Solution s2=new Solution();
        s2.generate2(5);
    }
}