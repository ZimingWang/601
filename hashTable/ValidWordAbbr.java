package hashTable;

import java.util.HashSet;

/**
 */
//    Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
//    Example:
//    Given dictionary = [ "deer", "door", "cake", "card" ]
//
//    isUnique("dear") -> false
//    isUnique("cart") -> true
//    isUnique("cane") -> false
//    isUnique("make") -> true
public class ValidWordAbbr {
    public static void main(String[] args){
        ValidWordAbbr vwa = new ValidWordAbbr(new String[]{"hello"});
        System.out.println(vwa.isUnique("hello"));
//        System.out.println(getAbbr("beaxyr"));
    }
    private static HashSet<String> set = new HashSet<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            set.add(getAbbr(s));
        }
    }

    public static boolean isUnique(String word) {
        String s = getAbbr(word);
        return !set.contains(s);
    }

    public static String getAbbr(String s){
        if(s.length() <= 2) return s;

        return s.charAt(0) + "" + (s.length()-2) + s.charAt(s.length()-1);
    }
}

