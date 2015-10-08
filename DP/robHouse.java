package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/6/15.
 */
public class robHouse {
    public int rob(int[] nums) {
        int a =0;
        int b=0;
        for(int i=0;i<nums.length;i++){
            //even
            if(i%2==0){
                a = Math.max(a+nums[i], b);
            }
            //odd
            else{
                b=Math.max(b+nums[i],a);
            }
        }
        return Math.max(a,b);
    }
    public int maxSumNotAdj(int[] nums) {
        int incl = nums[0];
        int excl = 0;
        for(int i=0;i<nums.length;i++){
            int tmp = incl;
        }
        return 0;
    }
    public int maxPro(int nums[]){
        if (nums==null || nums.length==0) return 0;
        int minPrice = nums[0]; // min price until now
        int maxPro = nums[0];
        for(int i=0;i<nums.length;i++){
            minPrice = Math.min(minPrice, nums[i]);
            maxPro = Math.max(maxPro, nums[i]-minPrice);
        }
        return maxPro;
    }
    public int countBST(int n){
        int[] T= new int[n+1];
        T[0]=T[1]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                T[i]=T[j]*T[i-j-1];
            }
        }
        return T[n];
    }
    /*
    Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

dfs(G graph,v){
    visited[v]=true;
    for(neigh:v.neighs){
        if(!visited[neigh] && ){
            dfs(G,neigh);
        }
    }
}
    */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
            return 0;
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(start);
        int level =1;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            visited.add(cur);
            // neighbors. each time,change one letter
            for(int i=0;i<cur.length();i++){ //change ith letter
                char[] arr = cur.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i] = c;
                    String newS = new String(arr); // generate one neigh
                    if( !visited.contains(newS) && dict.contains(newS)){
                        visited.add(newS);
                        queue.offer(newS);
                        if(newS.equals(end)){
                            return level;
                        }
                    }
                }
            }
            //
        }
        return 0;
    }
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val =x;
        }
    }




    }
