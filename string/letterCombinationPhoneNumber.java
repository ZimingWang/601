package string;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class letterCombinationPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return res;
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> newres = new ArrayList<String>();
            String chars = getString(digits.charAt(i));
            for(String s:res){
                for(char ch:chars.toCharArray()){
                    newres.add(s+ch);
                }
            }
            res = newres;
        }
        return res;
    }
    public static  String getString(char ch){
        switch(ch){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default: return "";
        }
    }
}
