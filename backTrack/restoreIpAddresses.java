package backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipingxiong on 9/5/15.
 */

public class restoreIpAddresses {
        public List<String> restoreIpAddresses(String s) {
            ArrayList<String> res = new ArrayList<>();
            if(s==null || s.length() ==0 ) return res;
            helper(s, 0, 1, new String(), res);
            return res;
        }

        public  void helper(String s,int start,int seg,String item,ArrayList<String> res){
            if(start>s.length())return;
            if(seg==4){
                String ss=s.substring(start);
                if(isValid(ss)){
                    res.add(item+"."+ss);
                }
                return;
            }
            for(int i=start;i<s.length();i++){
                String ss = s.substring(start,i+1);
                if(isValid(ss)){
                    helper(s,i+1,seg+1,item+"."+ss,res);
                }

            }
        }
    private boolean isValid(String str)
    {
        if(str==null || str.length()>3 || str.length()==0)
            return false;
        int num = Integer.parseInt(str);
        if(str.charAt(0)=='0' && str.length()>1)
            return false;
        if(num>=0 && num<=255)
            return true;
        return false;
    }
    public  static void main(String args[]){
        restoreIpAddresses ins = new restoreIpAddresses();
//        System.out.println(ins.restoreIpAddresses("25525511135"));
    }


  }
