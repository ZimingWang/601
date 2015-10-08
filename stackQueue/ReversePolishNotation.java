package stackQueue;

import java.util.Stack;

/**
 * Created by lipingxiong on 8/23/15.
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a,b;
        for(String s:tokens){
            switch(s){
                case "+":
                    stack.push( stack.pop() + stack.pop() );
                    break;
                case "-":
                    b=stack.pop();
                    a = stack.pop();
                    stack.push( a-b);
                    break;
                case "*":
                    stack.push( stack.pop() * stack.pop());
                    break;
                case "/":
                    b=stack.pop();
                    a = stack.pop();
                    stack.push( a/b);
                    break;
                default:
                    stack.push( Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        Integer.parseInt("12");
    }
}
