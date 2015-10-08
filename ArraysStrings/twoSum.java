package ArraysStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipingxiong on 10/2/15.
 */
/*
//two sum 没说清重复数据怎么算 我都算有效吧 {2,2,3,3,3} target=5 result=6;

int 2sum(vector<int>nums,int target){
int count=0;
unordered_map<int,int>  mp;
for(auto x:nums){
mp[x]++;
}
for(auto x:nums){
if(mp.find(target-x)!=mp.end()){. visit 1point3acres.com for more.
count+=mp[target-x];
}

return count/2;
}

 */
public class twoSum {
    int twoSumCount(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i:arr){
            if(!map.containsKey(i))map.put(i,1);
            else map.put(i, map.get(i)+1);
        }
        /*
        for(int key:arr){
            if(map.get(key)>0) {
                if (map.containsKey(target - key) && map.get(target-key)>0) {
                    count += 1;   //map.get(key) * map.get(target - key);
                    map.put(key, map.get(key) - 1);
                    map.put(target - key, map.get(target - key) - 1);
                }
            }
        }
        */
        for(int key:arr){
            if (map.containsKey(target - key) ) {
                count += map.get(target-key);
            }
        }

        return count/2;
    }
    public static void main(String[] args){
        twoSum ins = new twoSum();
        System.out.println(ins.twoSumCount(new int[]{2, 3, 3, 2, 3}, 5));
        System.out.println(ins.twoSumCount(new int[]{2, 3, 3, 4}, 6));
        System.out.println(ins.twoSumCount(new int[]{2, 3, 3, 4}, 7));
    }
}
