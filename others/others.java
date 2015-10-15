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
        String s="ABC";
        ArrayList<String> res = new ArrayList<>();
        o.f(s,"",res, s.length());
        System.out.println(res.size());
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
