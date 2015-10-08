package stackQueue;

import java.util.ArrayList;
import java.util.Stack;
//
/**
 *
 */
public class setofStack {
    ArrayList<Stack> stacks = new ArrayList<Stack>();

    public void push(int v){
        ;
    }
    public void pop(){
        ;
    }

    public Object popAt(int index){
        Stack stack = stacks.get(index);
        Object t = stack.pop();
        if(stack.isEmpty()){
            stacks.remove(index);
        }
        return t;
    }
    /*
    public Object leftshift(int index, boolean rmvTop){
        Stack stack = stacks.get(index);
        Object rmvItem;
        if (rmvTop) {
            rmvItem = stack.pop();
        }
        else{
            rmvItem = stack.getBottom();
        }
        if ( stacks.size() > index+1){
            Object v = leftshift(index+1, false);
            stack.push(v);
        }
        return rmvItem;
    }
    */
}