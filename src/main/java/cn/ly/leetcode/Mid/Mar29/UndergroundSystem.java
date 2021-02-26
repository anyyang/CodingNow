package cn.ly.leetcode.Mid.Mar29;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<String, Map<String, Metro>> sum = new HashMap<String, Map<String, Metro>>();
    Map<Integer, Tarvel> travel = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Tarvel tarvel = new Tarvel(t, stationName);
        travel.put(id, tarvel);
    }

    public void checkOut(int id, String stationName, int t) {
        synchronized (sum) {
            Tarvel tar = travel.get(id);//上车时间
            travel.remove(id);
            int costtime = t - tar.time;//花费时间
            Map<String, Metro> account = sum.get(tar.start); //该站点的总账本
            if (account == null) {//初始化账本
                Map<String, Metro> tempacount = new HashMap<String, Metro>();
                Metro station = new Metro(stationName, costtime, 1);
                tempacount.put(stationName, station);
                sum.put(tar.start, tempacount);
            } else {//有账本
                Metro station = account.get(stationName);
                if (station == null) {
                    Metro sta = new Metro(stationName, costtime, 1);
                    Map<String, Metro> tempacount = new HashMap<String, Metro>();
                    tempacount.put(stationName,sta);
                    sum.put(tar.start, tempacount);
                } else {
                    station.sumconut = station.sumconut + 1;
                    station.sumtime = station.sumtime + costtime;
                }
            }
        }

    }

    public double getAverageTime(String startStation, String endStation) {


        Map<String, Metro> account = sum.get(startStation);
        if(account==null){
            return 0;
        }
        Metro metro = account.get(endStation);
        if(metro==null){
            return 0;
        }
        return metro.getavg();
    }

}

class Tarvel {
    public Tarvel(int time, String start) {
        this.time = time;
        this.start = start;
    }

    int time;
    String start;
}

class Metro {
    public Metro() {
    }

    public Metro(String name, double sumtime, int count) {
        this.name = name;
        this.sumtime = sumtime;
        this.sumconut = count;
    }

    String name;
    double sumtime;
    int sumconut;

    public double getavg() {
        double result =  sumtime / sumconut;
        BigDecimal b = new BigDecimal(result);
        result= b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static void main(String[] args) {
        UndergroundSystem system = new UndergroundSystem();
        system.checkIn(1,"taoranting",1);
        system.checkOut(1,"sihuidong",10);
        System.out.println(system.getAverageTime("taoranting","sihuidong"));
    }
}
