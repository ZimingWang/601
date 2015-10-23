package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipingxiong on 8/30/15.
 */
public class wordBreak {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        dict = ["cat", "cats", "and", "sand", "dog"].
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        wordBreak2("catsanddog", set);
    }

//    public static void main(String args[]){
//        HashSet<String> set = new HashSet<>();
//        set.add("leet");
//        set.add("code");
//        System.out.println(breakWordDP("leetcode", set));
//        System.out.println(breakWordDP("leetcodes", set));
//    }
//accepted
    public static boolean wordBreak(String s,Set<String> dict){
        boolean[] t=new boolean[s.length()+1];
        t[0]=true;
        for(int i=0;i<s.length();i++){
            for(int j=i;j>=0;j--){
                if(t[j] && dict.contains(s.substring(j,i+1)) ){
                    t[i+1]=true;
                    break;
                }
            }
        }
        return t[s.length()+1];
    }

    /*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
     */
    public static ArrayList<String> wordBreak2(String s,Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        if(s==null||s.length()==0) return res;
        wordBreak2(s,dict,0,res,"");
        System.out.println(res);
        return res;
    }

    public static void wordBreak2(String s,Set<String> dict,int start,ArrayList<String> res, String item){
        if(start >= s.length()) {
            System.out.println(item);
            res.add(item);
            return ;
        }
//        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=start;i<s.length();i++){
//            String word = s.substring(start,i+1);
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString())) {

                wordBreak2(s,dict,i+1, res,item+" "+sb.toString());

            }
        }
    }

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



}
