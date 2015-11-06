package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 "412-294-2269,00:05:18"
 "413-227-8888,01:00:00"

 <=300s,3 cents/s
 >=301s, 150cents/m

 通话总时间最长的电话免费。
 */
public class phoneFee {

//    public class connectTime {
//        int hour;
//        int minute;
//        int second;
//
//        public connectTime(int h, int m, int s) {
//            hour = h;
//            minute = m;
//            second = s;
//        }
//
//        public int getSecond() {
//            return hour * 3600 + minute * 60 + second;
//        }
//
////        public int add(connectTime t2) {
////            return this.getSecond() + t2.getSecond();
////        }
//    }
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
//        String[] list = new String[]{ "412-294-2269,00:05:18","413-227-8888,01:00:00"};
        list.add("412-294-2269,00:01:01");
        list.add("413-227-8888,00:01:00");
        System.out.println(phoneFee(list) );
    }

    public static int phoneFee(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : list) {
            String[] arr = s.split(",");
            String phoneNum = arr[0].trim();
            String[] time = arr[1].trim().split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int second = Integer.parseInt(time[2]);
//            int period = getSecond(hour, minute, second);
            int price = 0;
            if(minute>=5 && second>0) {
                price = 150 * (hour*60 + minute + 1);
            }
            else price = 3 * (hour * 3600 + minute * 60 + second);

            if (!map.containsKey(phoneNum)) map.put(phoneNum, price );
            else map.put(phoneNum, map.get(phoneNum) + price);
        }

        int max=0;
        String freePhone="";
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String key = entry.getKey();
            int price = entry.getValue();
            if(price>max){
                max = price;
                freePhone = key;
            }
        }
//        for(String key: map.keySet()){
//            int price = map.get(key);
//            if(price>max){
//                max = price;
//                freePhone = key;
//            }
//        }
        map.remove(freePhone);

        int sum=0;
        for(int price: map.values()){
            sum += price;
        }
        return sum;
    }

//    public int getSecond(int hour,int minute,int second) {
//        return hour * 3600 + minute * 60 + second;
//    }

}
