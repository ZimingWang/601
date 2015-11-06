package ArraysStrings;

import java.sql.Timestamp;
import java.util.*;

/**
 */
public class arrays {
    public static void main(String[] args) {
        arrays a = new arrays();
        int[] nums = new int[]{3, 4};
//        a.searchInsert(nums, 5);
        nums = new int[]{1, 3, 5, 6};
//        a.ceilFloor(nums,2);
//        [1,3,5,6], 2
//        String S = "ADOBECODEBANC";
//        String T = "ABC";
//        String res = a.minWindow(S, T) ;
//        System.out.println(res);
//        oneDistance("abcd","acbd");
//        oneDistance("abcd","abc");
//        oneDistance("ab","abc");
//        oneDistance("abc","ac");
//        oneDistance("a","a");
//        oneDistance("","a");
//        oneDistance("bc","cb");
//        String s = "ab";
//        String t = "abc";
//        System.out.println(s.substring(1));
//        System.out.println(s.substring(2).equals(t.substring(3)) );
//        System.out.println(stemmer("computer computed computes compute"));
//
//        Date date = new java.util.Date();
//        System.out.println(new Timestamp(date.getTime()));
//        Date date1=new Date(2010,04,05,10,01,10);
//        Date date2=new Date(2010,04,05,10,02,00);
////        Date date2=new Date(2010,04,06,02,01,10 );
//        System.out.println("相差"+Math.abs((date1.getTime()-date2.getTime())/(1000))+"秒");

//        System.out.println(a.threeSum(new int[]{-1, 0, 1, 2 ,-1 ,-4}) );
//        System.out.println(a.threeSumClosest(new int[]{-4,-1,1,2},1));
//        System.out.println(a.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) );
//        System.out.println(a.jump(new int[]{1,2}));
//        System.out.println(a.jump(new int[]{0}));
//        System.out.println( a.findMissingRanges(new int[]{0, 1, 3, 50, 75},0,99));
//        com.com.ptrArr(a.plusOne(new int[]{1, 2, 3}));
//        com.com.ptrArr(a.plusOne(new int[]{1, 2, 9}));
//        com.com.ptrArr(a.plusOne(new int[]{9, 9, 9}));
//        com.com.ptrArr( a.productExceptSelf(new int[]{1, 2, 3,4}) );
//        System.out.println(a.removeDuplicates(new int[]{1,1,1,2,2,3}));
//        System.out.println(a.combinationSum(new int[]{10,1,2,7,6,1,5},8));
//        System.out.println(a.combinationSum(3,7));
//        System.out.println(a.getFactors(32));
//        System.out.println(a.solveNQueens(4));
//        System.out.println(a.wordBreak("abc",));
//        System.out.println(a.subsets(new int[]{1,2,3}));
    }
    /*
    Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */


    public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if(s==null || s.length()==0)
            return res;
    helper(s, getDict(s),0,new ArrayList<String>(), res);
    return res;
}
    private void helper(String s, boolean[][] dict, int start, ArrayList<String> item, List<List<String>> res) {
        if(start==s.length()){
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i=start;i<s.length();i++){
            String ss = s.substring(start, i+1);
            if( dict[start][i] ){
                item.add(ss);
                helper(s,dict,i+1,item,res);
                item.remove(item.size()-1);
            }
        }
    }

    private boolean[][] getDict(String s){
        int n = s.length();
        boolean[][] t = new boolean[n][n];
//        t[n][n]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && j-i <=2 ||  t[j+1][i-1] ){
                    t[j][i] = true;
                }
            }
        }
        return t;
    }

/*
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
     */

//    Input:Digit string "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


    /*
    "aa"
     */
//    public List<List<String>> partition(String s) {
//
//    }

    /*
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
 */
//    public List<ArrayList<Integer>> combinationSum(int k, int sum) {
//        List<ArrayList<Integer>> res = new ArrayList<>();
//        helper(k, sum, 1, new ArrayList<Integer>(),res);
//        return res;
//    }
//
//    private void helper(int k, int sum, int start, ArrayList<Integer> item, List<ArrayList<Integer>> res){
//        if(sum<0)return;
//        if(item.size()==k && sum==0){
//            res.add(new ArrayList<Integer>(item));
//            return;
//        }
//        for(int i=start;i<9;i++){
//            item.add(i);
//            helper(k, sum - i, i + 1, item, res);
//            item.remove(item.size()-1);
//        }
//    }
    /*
    input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
     */


    public static boolean canJump(int[] A) {
        int n = A.length;
        int maxReach = A[0];
        for(int i=0;i<n && i<maxReach;i++){
            if(maxReach >= n) return true;
            maxReach = Math.max(maxReach,A[i]+i);
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(A);
//        ArrayList<ArrayList<Integer>> newRes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> twosumres = new ArrayList<>();

        for (int i = A.length-1; i>=0; i--) {
            twosumres = twoSum(A, -A[i], i-1);
            for (ArrayList<Integer> list : twosumres) {
                list.add(A[i]);
                res.add(list);
            }
        }
        return  res;
    }
    public ArrayList<ArrayList<Integer>> twoSum(int[] A, int target, int r){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 0;
        while(l < r){
           if(A[l] +A[r] == target) {
               ArrayList<Integer> item = new ArrayList<>();
               item.add(A[l]);
               item.add(A[r] );
               res.add(item);
               l++;
               r--;
           }
           else if((A[l]+A[r]) > target ) {
                r--;
            }
            else {
               l++;
           }
        }
        return res;
    }


    public static int minDiff(int[] data){
        int left=0;
        int right=0;
        int diff = Integer.MAX_VALUE;
        int min = 0;
        for(int i=0;i<data.length-1;i++){
            right += data[i];
        }
        for(int i=0;i<data.length-1;i++){
            right -= data[i];
            if(Math.abs(right-left) < diff){
                diff = Math.abs(right-left);
                min = i;
            }

            left += data[i];
        }
        return min;
    }



//    computer computed computes compute

    public static String stemmer(String inputTerms) {
        inputTerms = inputTerms.trim();
        String[] arr = inputTerms.split(" ");
        int n = arr.length; // words count
        int i = 0;
        while(true){
            if(i>=arr[0].length()) return arr[0].substring(0,i);
            char ch = arr[0].charAt(i);
            for(int k=1;k<n;k++){
                if(i>=arr[k].length() || arr[k].charAt(i) != ch){
//                    break;
                    return arr[k].substring(0,i);
                }
            }
            i++;
        }

    }

    /*
if S can be converted to T by inserting or deleting a Character, output "INSERT x"  and " DELETE x" respectively.
If S is different from T in that two consective characters in S can be swapped to get T, output "SWAP x y".
   Otherwise, output "IMPOSSIBLE"
    */

    public static void oneDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(Math.abs(m-n) > 1) {
            System.out.println("IMPOSSIBLE");
            return ;
        }
        int minLen = Math.min(s1.length(),s2.length());
        int i=0;
        for(;i<=minLen;i++){
            if( i==minLen || s1.charAt(i)!=s2.charAt(i) ){
                if(m==n){ //eaual size
                    if(i==minLen) { // all letters are same
                        System.out.println("Nothing");
                        return;
                    }
//                    if(s1.substring(i+1).equals(s2.substring(i+1))){
//                        System.out.println("Replace x y");
//                        return ;
//                    }
                    if(i<minLen-1 && s1.charAt(i)==s2.charAt(i+1) && s2.charAt(i)==s1.charAt(i+1) && s1.substring(i+2).equals(s2.substring(i+2))){
                        System.out.println("SWAP x y");
                        return;
                    }

                }
                else if(m<n){
                    if(s1.substring(i).equals( s2.substring(i+1) )) {
                        System.out.println("INSERT x");
                        return;
                    }
                }
                else if(m>n){
                    if(s1.substring(i+1).equals( s2.substring(i))) {
                        System.out.println("DELETE x");
                        return;
                    }
                }
                break;
            }
        }

        System.out.println("IMPOSSIBLE");
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
