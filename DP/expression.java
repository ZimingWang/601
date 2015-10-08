package DP;

import java.util.HashMap;

/**
 * Created by lipingxiong on 8/19/15.
 * 1^0|0|1
 */

public class expression {
    public int f(String exp, boolean result, int s, int e, HashMap<String,Integer> q){
        // f( exp1&exp2, true ) = f( exp1, true) +  f()
//        int c = 0;
        // Save history data
        String k= ""+result+s+e;
        if(q.containsKey(k) ){
            return q.get(k);
        }
        // Base condition,subproblem reduce to one char,
        if(s==e){
            if(result && exp.charAt(s) == '1'){
                return 1;
            }
            else if(!result && exp.charAt(s) == '0'){
                return 1;
            }
            return 0;
        }
        int c=0;
        for(int i=s+1;i<=e;i++) {
           char opt=exp.charAt(i);
           if(result) {
               if (opt == '&') {//AND, both exps must be true
                   c = f(exp, true, s, i-1, q) * f(exp, true, i+1, e, q);
               }
               else if(opt == '|'){ //OR,one is ture or both are true
                   c = f(exp,true,s,i-1,q) * f(exp,true,i+1, e,q)
                   + f(exp,true,s,i-1,q) * f(exp,false,i+1,e,q)
                   + f(exp,false, s,i-1,q) * f(exp,false,i+1,e,q);
               }
               else if(opt == '^'){
                   c = f(exp,true,s,i-1,q) * f(exp,false,i+1,e,q)
                           + f(exp,false, s,i-1,q) * f(exp,true,i+1,e,q);
               }
           }
           else{
               if (opt == '&') {//AND, both exps must be false
                   c = f(exp, false, s, i-1, q) * f(exp, false, i+1, e, q);
               }
               else if(opt == '|'){ //OR,one is false or both are false
                   c = f(exp,false,s,i-1,q) * f(exp,false,i+1, e,q)
                           + f(exp,true,s,i-1,q) * f(exp,false,i+1,e,q)
                           + f(exp,false, s,i-1,q) * f(exp,false,i+1,e,q);
               }
               else if(opt == '^'){
                   c = f(exp,true,s,i-1,q) * f(exp,true,i+1,e,q)
                           + f(exp,false, s,i-1,q) * f(exp,false,i+1,e,q);
               }
           }
        }

        q.put(k,c); // save to avoid repeat
        return c;
    }
}
