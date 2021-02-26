package cn.ly.leetcode.Mid.Sep8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 求出今天星期几
 */
public class Soluation1 {
    public String dayOfTheWeek(int day, int month, int year) {
        String strDate= year+"-"+month+"-"+day;
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
           date=simpleDateFormat.parse(strDate);

        } catch(ParseException px) {
            px.printStackTrace();
        }
        String dateStr[] = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String result = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
       // System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekDay < 0) {
            weekDay = 0;
        }
      //  System.out.println(weekDay);
        result = dateStr[weekDay];
        return result;
    }

    public static void main(String args[]) {
        Soluation1 s1 = new Soluation1();
        System.out.println(s1.dayOfTheWeek(8, 9, 2019));
    }
}
