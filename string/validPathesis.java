package string;

import java.util.HashMap;
import java.util.LinkedList;

/**
 */
public class validPathesis {
    public static boolean isValid(String s){
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character,Character> map =new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                if(ch!= map.get(stack.pop()) ) return false;
            }
        }
        return  stack.isEmpty();
    }

}
