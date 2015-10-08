package stackQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by lipingxiong on 8/16/15.
 */
public class ListStack<E> {

    private List<E> data;

    ListStack(){
        this.data = new ArrayList<E>();
    }

    public E push(E e){
        this.data.add(e);
        return e;
    }

    public E pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.data.remove(this.data.size()-1);
    }
    public E peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.data.get(this.data.size() - 1);
    }
    public boolean isEmpty(){
        return this.data.size() == 0;
    }
    public static void main(String[] args){
        ListStack<Integer> stack = new ListStack<Integer>();

        System.out.println(stack.isEmpty());
        System.out.println(stack.push(2));
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
