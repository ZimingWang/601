package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipingxiong on 8/30/15.
 */
public class wordBreak {
    public static boolean breakWordDP(String word, Set<String> dict) {
        int n = word.length();
        int T[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                T[i][j] = -1;  // can not be split
            }
        }
        for(int l=1;l <= n;l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                String str = word.substring(i, j + 1);
                if (dict.contains(str)) {
                    T[i][j] = i;
                    continue;
                }
                else{
                    for(int k=i;k<j;k++) {
                        if(T[i][k]!=-1 && T[k+1][j]!=-1 ) {
                            T[i][j]=i;
                            break;
                        }
                    }
                }
            }
        }
        if( T[0][n-1] == -1){
            return false;
        }
        int i =0;
        int j = n -1;
        int k =0;
        StringBuilder sb = new StringBuilder();
        while(i<j){
            k = T[i][j];

            sb.append(word.substring(i, k + 1) + " ");
            i=k+1;
        }


        return T[0][n-1]!=-1;
        /*
        StringBuilder sb = new StringBuilder();
        int i=0;r
        int j =n-1;
        while(i<j){
            int k=T[i][j];


            i=k;
        }
        return sb.toString();
        */
    }


    public static void main(String args[]){
        HashSet<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(breakWordDP("leetcode", set));
        System.out.println(breakWordDP("leetcodes", set));
    }

}
