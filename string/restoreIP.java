package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 10/25/15.
 */
public class restoreIP {
    public static void main(String[] args){
        System.out.println(restoreIpAddresses("25525511135"));
    }
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if(s==null) return res;

        String item = "";

        helper(s,0,1,item,res);// start =0, seg = 1

        return res;
    }
    public static void helper(String s,int start,int seg,String item,ArrayList<String> res){

        if(seg==4){
            String lastseg = s.substring(start);
            if(isValid(lastseg)){
                item += "."+lastseg;
                res.add(item);
            }
            return;
        }
        for(int i=start;i<s.length();i++){
            String ss = s.substring(start,i+1);
            if( isValid(ss) ){
                if(item=="") helper(s,i+1,seg+1,ss,res);
                else helper(s,i+1,seg+1,item+"."+ss,res);
            }
        }
    }

    public static boolean isValid(String str){
        if(str.length() > 3 || str.length() < 1){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') return false;
        }
        if(Integer.parseInt(str) > 255 ) return false;
        return true;
    }

}
