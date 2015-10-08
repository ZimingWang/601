package stackQueue;

import java.util.Stack;

/**
 * Created by lipingxiong on 8/16/15.
 */
//Implement a MyQueue class which implements a queue using two stacks.
public class myQueueWith2Stacks<T> {

    Stack<T> stackOldest, stackNewest;
    public myQueueWith2Stacks(){
        this.stackOldest = new Stack<>();
        this.stackNewest = new Stack<>();
    }
    public T push(T t){
        stackNewest.push(t);
        return t;
    }
    public T pop(){
        if (stackOldest.isEmpty()) {
            this.shift();
        }
        return stackOldest.pop();
    }
    private void shift(){
        while( !stackNewest.isEmpty()){
            stackOldest.push( stackNewest.pop() );
        }
    }
    public T peek(){
        if(stackOldest.isEmpty()){
            this.shift();
        }
        return stackOldest.peek();
    }

}
