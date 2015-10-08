package DP;

import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/10/15.
 */
public class DPstack {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()) {
                    start = i+1;
                }
                else{
                    int top = stack.pop();
                    max = stack.isEmpty() ?  Math.max(max,i-start+1) : Math.max(max,i-stack.peek()) ;
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        DPstack ins=new DPstack();
        System.out.println(ins.longestValidParentheses("((()()"));
    }
}
