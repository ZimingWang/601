package others;

import java.util.*;

/**
 * Created by lipingxiong on 8/19/15.
 */
public class others {
    public static void main(String[] args){
//        System.out.println(compareVersion("1.1", "0.2"));
//        System.out.println(compareVersion("1.1", "1.1.1"));
//        System.out.println(compareVersion("1.0", "1.0.000"));
//        int[] A = new int[] {-10, -5, 0, 3, 7};
//        int[] A = new int[]{-10, -5, 3, 4, 7, 9};
//        System.out.println(find(A));
        others ins = new others();
        System.out.println(ins.isOneEditDistance("acd","abef") );
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
