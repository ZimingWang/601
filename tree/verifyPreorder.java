package tree;

import java.util.Stack;

/**
 * Created by lipingxiong on 8/25/15.
 */
public class verifyPreorder {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low=Integer.MIN_VALUE;
        for(int i : preorder){
            if(i>low) return false;
            while(!stack.isEmpty() && i>stack.peek()){
                low=stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

}
