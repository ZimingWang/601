package ArraysStrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lipingxiong on 10/12/15.
 */
public class arrays {
    public static void main(String[] args){
        arrays a= new arrays();
        int[] nums=new int[]{3,4};
//        a.searchInsert(nums, 5);
        nums = new int[]{1,3,5,6};
//        a.ceilFloor(nums,2);
//        [1,3,5,6], 2
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String res = a.minWindow(S,T) ;
        System.out.println(res);
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int n:nums){
            if(n!=0){
                nums[count++]=n;
            }
        }
        for(int i=count;i<nums.length;i++){
            nums[i]=0;
        }
    }
/*
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[] t= new int[n];
        for(int j=0;j<n;j++) t[j]=triangle.get(n-1).get(j);

        for(int i=n-2;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for(int j=0;j<=i;j++) {
                int min=t[j];
//                if(j>0) min = Math.min(min,t[j-1]);
                min= Math.min(min,t[j+1]);
                t[j] = list.get(j) + min;
            }
         }
        return t[0];
    }

    public int removeElement(int[] A, int elem) {
        int n = A.length;
        int i=0;
        int j = n-1;
        while(i<j){
            while(i<n && A[i]!=elem) i++; //until A[i]==elem
            if(i>=n) return n;
            while(j>i && A[j]==elem) j--;
            A[i++]=A[j--];
        }
        if(i==j && A[i]==elem ) return j;
//        else if(i==j && A[i]!=elem ) return j+1;
        return j+1;
    }

    /*
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".
    */
    public String minWindow(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else
            {
                map.put(T.charAt(i),1);
            }
        }
        int min=S.length(),beg=0,end=0;
        int m =S.length();
        int n = T.length();
        int start=0;
        HashMap<Character,Integer> curmap = new HashMap<>();
        int count=0;
//        while(start<m && !map.containsKey(ch)) start++;
        for(int i=0;i<S.length();i++) {
            char ch = S.charAt(i);
//            start = i;

            //in T,and still need, count++
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    count++;
                }
            }
            while(count==T.length()){//find a window
                min = Math.min(min, i-start + 1 );
                beg=start; end=i;
                start++;
                ch = S.charAt(start);
                if( map.containsKey(ch) ) {
                    ch = S.charAt(start);
                    map.put( ch,map.get(ch)+1 );
                    if(map.get(ch)>0) count--;
                }
            }
        }
        return S.substring(beg,end+1);

    }

    int [] ceilFloor(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                return (m==0) ? new int[]{-1,1} : new int[]{m-1,m+1};
            }
            else if(target < nums[m]){
                r=m-1;
            }
            else l=m+1;
        }
        int[] res = new int[2];
        res[0]=r;
        res[1]=l;
//        if(l==0) res[0]=-1;
        System.out.println(r+" "+l);
        return res;
    }

    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0)
        {
            return 0;
        }
        int l = 0;
        int r = A.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(A[mid]==target)
                return mid;
            if(A[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        System.out.println(r+" "+l);
        return l;
    }
}
