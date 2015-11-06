package others;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lipingxiong on 8/19/15.
 */
public class others {
    public static void main(String[] args) {
//        System.out.println(compareVersion("1.1", "0.2"));
//        System.out.println(compareVersion("1.1", "1.1.1"));
//        System.out.println(compareVersion("1.0", "1.0.000"));
//        int[] A = new int[] {-10, -5, 0, 3, 7};
//        int[] A = new int[]{-10, -5, 3, 4, 7, 9};
//        System.out.println(find(A));
//        others ins = new others();
//        System.out.println(ins.isOneEditDistance("acd","abef") );
//        perm("ABC");
        others o = new others();
//        o.moveZeroes(new int[]{0, 1, 0, 3, 12});
//        int[] nums=new int[]{-2, 0, 1, 3};
//        o.threeSumSmaller(nums,2);

//        o.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        o.trap(new int[]{0,1,0,2,1,1});
//        o.trap(new int[]{4,3,2,1,5});
//        System.out.println("56#".indexOf("#"));
//        List<String> strs=o.decode("3#abc2#ef");
//        System.out.println(o.encode(strs));

//        String s="ABC";
//        ArrayList<String> res = new ArrayList<>();
//        o.f(s,"",res, s.length());
//        System.out.println(res.size());

//        int res = Integer.parseInt("05") + 1;
//        System.out.println(res);


//        oneDistance("abcd", "acbd");
//        oneDistance("abcd", "abc");
//        oneDistance("ab", "abc");
//        oneDistance("abc", "ac");
//        oneDistance("a", "a");
//        oneDistance("", "a");

//        System.out.println(biggestSibling(253));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(4*Integer.MAX_VALUE * Integer.MAX_VALUE) ;
//
//        System.out.println(4*Integer.MAX_VALUE * Integer.MAX_VALUE < Long.MAX_VALUE) ;
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Double.MAX_VALUE);

//        String s = "ab";
//        String t = "abc";
//        System.out.println(s.substring(1));
//        System.out.println(s.substring(2).equals(t.substring(3)) );
//        System.out.println("abc".substring(1));
}

//    public static int longestchain(String[] dict){
//        HashSet<String> set = new HashSet<>();
//        int max =0;
//        for(String s:dict){
//            set.add(s);
//        }
//        for(String s:dict) {
//            max = Math.max(max, longestchain(set, s));
//        }
////        max = longestchain(set,"abcd");
//        return max;
//    }
//    public static int longestchain(HashSet<String> set,String cur){
//        System.out.println("cur="+cur);
//        ptrSet(set);
//
//        if(cur.length()==1) return 1;
//        int max= 0;
//
//        set.remove(cur);
//        for(int i=0;i<cur.length();i++){
//            String substr = cur.substring(0,i)+cur.substring(i+1);//remove charAt(i)
////            System.out.println(substr);
//
//            if(set.contains(substr)){
//                int res = longestchain(set,substr);
//                max = Math.max(max,res + 1);
//            }
//        }
//        set.add(cur);//recover
//        return max;
//    }



//
//    第一题，把一个integer的数字顺序打乱后得到的新的integer叫做该integer的sibling   比如 123和231，132，213，321都是sibling，但和222就不是。
//    写个程序找一个integer的所有sibling里面最大的。比如上面那个例子返回321.
//    我的思路就是把integer弄成string 再转成char array，然后sort一下，再转回integer。注意最后的integer可能会溢出，所以查看edge case

    public static int biggestSibling (int n){
        int res = 0;
        String s = String.valueOf(n);
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
            res = res*10 + (int)(arr[i]-'0');
        }
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return res;
    }


//    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
//        int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
//        int bottom = Math.max(B,F), top = Math.max(Math.min(D, H), bottom);
//        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
//    }
//    int solution(int K, int L, int M, int N, int P, int Q, int R, int S){
//        int left = Math.max(K, P), right = Math.max(Math.min(M, R), left);
//        int bottom = Math.max(L, Q), top = Math.max(Math.min(N, S), bottom);
//        return (M-K)*(N-L) - (right-left)*(top-bottom) + (R-P)*(S-Q);
//    }
//
//    int computeArea(int K, int L, int M, int N, int P, int Q, int R, int S){
//        // write your code in Java SE 8
//        long res = 0;
//        long area_1 = (M-K)*(N-L);
//        long area_2 = (R-P)*(S-Q);
//
//        if(M <= P || L >= S || R <= K || Q >= N){
//            res = area_1 + area_2;
//        }
//        else {
//            int left = Math.max(K, P);
//            int right = Math.min(M, R);
//
//            int bottom = Math.max(L, Q);
//            int top = Math.min(N, S);
//
//            res = area_1 + area_2 - (right - left) * (top - bottom);
//        }
//        return res > Integer.MAX_VALUE ? -1 : (int)res;
//    }

    int computeArea(int K, int L, int M, int N, int P, int Q, int R, int S){
        // write your code in Java SE 8
        double res = 0;
        double area_1 = (M-K)*(N-L);
        double area_2 = (R-P)*(S-Q);

        if(M <= P || L >= S || R <= K || Q >= N){
            res = area_1 + area_2;
        }
        else {
            int left = Math.max(K, P);
            int right = Math.min(M, R);

            int bottom = Math.max(L, Q);
            int top = Math.min(N, S);
            double overlap = (right - left) * (top - bottom);
            res = area_1 + area_2 - overlap;
        }
        return res > Integer.MAX_VALUE ? -1 : (int)res;
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
                if(m==n){
                    if(i==minLen) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    if(s1.substring(i+1).equals(s2.substring(i+1))){
                        System.out.println("Replace x y");
                        return ;
                    }
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




    void f(String s,String item, ArrayList<String> res,int len){
        if(len==0){
            res.add(item);
            return;
        }
        for(int i=0;i<s.length();i++){
            f(s,item+s.charAt(i),res,len-1);
        }
    }
    public List<String> decode(String s) {
        ArrayList<String> strs = new ArrayList<>();
        int i=0,j=0,len=0;
        while(i<s.length()){
            int index = s.indexOf("#",i);
//            System.out.println(index);
            len = Integer.parseInt(s.substring(i, index));
            j = index + len;
            strs.add(s.substring(index+1,j+1));
            System.out.println(strs);
            i=j+1;
        }
//        System.out.println(strs);
        return strs;
    }

    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();
        for(String s:strs){
            sb.append(s.length() ).append('#').append(s);
        }

        return sb.toString();
    }

    /*
    0,1,0,2

     */
    public int trap(int[] height) {
        int l=0;
        int r = height.length-1;
        int water=0;
        while(l<r) {
            int min = Math.min(height[l],height[r]);
            if(height[l] < height[r]){
                l++;
                while (height[l] < min) {
                    water += min - height[l];
                    l++;
                }
            }
            else{
                r--;
                while (height[r] < min) {
                    water += min - height[r];
                    r--;
                }
            }
        }

        System.out.println(water);
        return water;
    }

    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <= 2)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int count=0;
        for(int k=2;k<n;k++){
            int j = k-1,i=0;
            while(i<j)
                if(nums[i]+nums[j]+nums[k]<target){ //i...j,i..j-1,i..j-2;   j-i
                    count+=j-i;
                    i++;
                }
                else j--;
        }
        System.out.println(count);
        return count;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int end = 0;
        for(int i =0;i<n;i++) {
            if(nums[i]!=0)nums[end++]=nums[i];
        }
        while(end<n){
            nums[end++]=0;
        }

        for(int e:nums){
            System.out.print(e);
        }
    }

    public int maxSquare(int[][] matrix){
        int m= matrix.length;
        int n = matrix[0].length;
        int[][] DP = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (matrix[i][j]==0){
                    DP[i][j] = 0;
                }
                else{
                    DP[i][j]=Math.min(Math.min( DP[i-1][j-1],DP[i-1][j]) , DP[i][j-1]) + 1;
                }
            }
        }
        return DP[m-1][n-1];
    }

    public static ArrayList<String> perm(String s){
        boolean[] used = new boolean[s.length()];
        ArrayList<String> res = new ArrayList<String>();
        perm(s,0,"",res, used);
        System.out.println(res);
        return res;
    }

    private static void perm(String s,int start, String item ,ArrayList<String> res,boolean used[] ){
        if(item.length() == s.length()) {
            res.add(item);
            return;
        }
        for(int i=0;i<s.length();i++) {
//            item.add();
            if(!used[i]) {
                used[i] = true;
                perm(s, i, item + s.charAt(i), res,used);
                used[i] = false;
            }
        }
    }


    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                System.out.println(i);
                System.out.println(s.substring(i + (s.length() >= t.length() ? 1 : 0)) );
                System.out.println( t.substring(i + (s.length() <= t.length() ? 1 : 0)));
                return s.substring(i + (s.length() >= t.length() ? 1 : 0)).equals(t.substring(i + (s.length() <= t.length() ? 1 : 0)));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public class Server {
        HashMap<Integer, Machine> machines = new HashMap<>();
        HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

        public Machine getMachineWithId(int machinelD) {
            return machines.get(machinelD);
        }

        public int getMachineIDForUser(int personID) {
            Integer machinelD = personToMachineMap.get(personID);
            return machinelD == null ? -1 : machinelD;
        }
        public Person getPersonWithID(int personID){
            int machineID = getMachineIDForUser(personID);
            Machine machine = getMachineWithId(machineID);
            return machine.getPersonWithID(personID);
        }
    }

//Given an array of unique integers in increasing order,
// return the integer with its value equal to its index in the array
    /*
0 1 2 3
     */
    public static int find(int[] A){
        int l=0, r=A.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(A[m]==m) return m;
            else if(A[m]>m) r=m-1;
            else l=m+1;
        }
        return -1;
    }

    int findMin(int[] A){
        int l =0, r=A.length-1;
        int min = A[0];
        while(l<=r){
            int m = l + (r-l)/2;
            if(A[l] < A[m]){
                min = Math.min(A[l],min);
                l = m+1;
            }
            else{
                min = Math.min(A[m],min);
                r = m - 1;
            }
        }
        return min;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int minLen = Math.min(v1.length, v2.length);
        int i=0;
        while(i<minLen){
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
            else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
            i++;
        }
        while(i<v1.length){
            if(Integer.parseInt(v1[i]) != 0 )  return 1;
            i++;
        }
        while(i<v2.length) {
            if(Integer.parseInt(v2[i]) != 0) return -1;
            i++;
        }
        return 0;
    }
    public void reverseWords(char[] s){
        reverseWords(s, 0, s.length - 1);
        int i = 0;
        while(i <= s.length){
            int j = i;
            while(j<s.length && s[j] != ' '){
                j++;
            }
            reverseWords(s,i,j-1);
            i = j+1;
        }
    }
    public void reverseWords(char[] s, int l, int r){
        while(l<r){
            char tmp= s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }


/*
personID: 0
friendIDs: [0,1,2,3]
 */
        public class Person {
            private ArrayList<Integer> friendIDs;
            private int personID;

            public Person(int id){ this.personID = id;}
            public int getID() { return personID; }
            public void addFriend(int id){ friendIDs.add(id); }
        }
/*
machineId
persons: {id:Person, ,}
 */
        public class Machine {
            public HashMap<Integer,Person> persons = new HashMap<>();
            public Integer machineId;

            public Person getPersonWithID(int personID) {
                return persons.get(personID);
            }
        }

}
