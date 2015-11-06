package others;

import java.util.Stack;

/**
 * AndrewID:lipingx
 */
public class verifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low=Integer.MIN_VALUE;

        for(int i : preorder){
            if(i<low) return false;
            // pop out the ones that smaller than preorder[i] and update the "low"
            while(!stack.isEmpty() && i>stack.peek()){
                low=stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}

