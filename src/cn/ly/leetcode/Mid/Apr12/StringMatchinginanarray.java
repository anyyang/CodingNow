package cn.ly.leetcode.Mid.Apr12;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
 */
public class StringMatchinginanarray {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null) {
            return null;
        }
        if (words.length < 2) {
            return result;
        }
        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {
                   if(i!=j&&words[j].contains(words[i])){
                       result.add(words[i]);
                       break;
                   }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        StringMatchinginanarray sm= new StringMatchinginanarray();
        String[] arrstr = new String[]{"mass","as","hero","superhero"};
        sm.stringMatching(arrstr);
    }

}
