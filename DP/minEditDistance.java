package DP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 */
public class minEditDistance {

//    public static void main(String[] args){
//        minDistance("ab","a");
//        minDistance("abcdef","azced");
//    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
        final String fileName = "/Users/lipingxiong//Downloads/test_cases_gerf00rn5lk/output.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _misspelledWord;
        try {
            _misspelledWord = in.nextLine();
        } catch (Exception e) {
            _misspelledWord = null;
        }

        int _dictionaryWords_size = 0;
        //_dictionaryWords_size = Integer.parseInt(in.nextLine());
        //String[] _dictionaryWords = new String[_dictionaryWords_size];
        String[] _dictionaryWords = in.nextLine().split(" ");
        /*
        String _dictionaryWords_item;
        for(int _dictionaryWords_i = 0; _dictionaryWords_i < _dictionaryWords_size; _dictionaryWords_i++) {
            try {
                _dictionaryWords_item = in.nextLine();
            } catch (Exception e) {
                _dictionaryWords_item = null;
            }
            _dictionaryWords[_dictionaryWords_i] = _dictionaryWords_item;
        }
        //*/

        res = levenshteinDistance(_misspelledWord, _dictionaryWords);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

//    private static int minDis = Integer.MIN_VALUE;

    public static String levenshteinDistance(String misspellledword,String[] dict){
        int minDis = misspellledword.length();
        String closeStr = "";
        for(String word: dict) {
            int res = minDistance(misspellledword, word);
            if(res < minDis){
                minDis=res;
                closeStr = word;
            }
        }
//        System.out.println(minDis);
//        System.out.println(closeStr);
        return minDis+","+closeStr;
    }
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int[][] T= new int[m+1][n+1]; //

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0) T[i][j]=j;
                else if(j==0) T[i][j]=i;
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    T[i][j]=T[i-1][j-1];
                }
                else{
                    T[i][j] = Math.min(Math.min(T[i][j - 1], T[i-1][j]), T[i-1][j-1]) + 1;
                }
            }
        }
        int res = T[m][n];
//        System.out.println(res);
        return res;
    }

}
