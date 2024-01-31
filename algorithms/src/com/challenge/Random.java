package com.challenge;


import java.util.HashMap;

public class Random {
    public int flipCoin(){
        return 0;
    }
    public int getValue(int N){
        int index =0;
        while(index<=N){
            index ++;
            if(flipCoin()==0)
                return index;
        }
        return 0;
    }


    public static void main(String[] args) {
        Random obj= new Random();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<10_000; i++){
             int value = obj.getValue(100);
             if(map.containsKey(value)){
                 int total = map.get(value);
                 total++;
                 map.remove(value);
                 map.put(value, total);
             }else{
                 map.put(value, 1);
             }
        }
        System.out.println(map.toString());

        /*
{0=720, 1=825, 2=1027, 3=1168, 4=1098, 5=1014, 6=937, 7=886, 8=838, 9=806, 10=681}
         */
    }
}
