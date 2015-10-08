package ArraysStrings;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lipingxiong on 8/26/15.
 Question:
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class isValidParen {
    HashMap<Character,Character> map= new HashMap<Character,Character>(){{
        put('{','}');
        put('(',')');
        put('[',']');
    }};
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<Character>();
        // when {,(,[; add to stack
        for(char c:s.toCharArray()) {
            if(map.containsKey(c)){
                stack.push(c);
            }
            // },),] when stack is empty or doesn't match , return false;
            else if(stack.isEmpty()|| map.get(stack.pop())!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
