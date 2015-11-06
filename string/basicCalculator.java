package string;

import java.util.Stack;
/**
 */
public class basicCalculator {
    public static void main(String[] args){
        calculate("3/2");
        calculate("5 -7");
    }
    public static int calculate(String s){
        s=s.trim();
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign='+';
        int len = s.length();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            if(Character.isDigit(ch)){
                num = num*10 + ch -'0';
            }
            if(!Character.isDigit(ch) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                else if(sign=='+'){
                    stack.push(num);
                }
                else if(sign=='/'){
                    stack.push( stack.pop() / num);
                }
                else if(sign == '*'){
                    stack.push( stack.pop() * num );
                }
                num =0;
                sign = ch;
            }
        }
        int res = 0;
        for(int i:stack){
            res += i;
        }
        System.out.println(res);
        return res;
    }
}
