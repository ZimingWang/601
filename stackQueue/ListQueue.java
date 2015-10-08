package stackQueue;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 8/16/15.
 */
public class ListQueue<E> {
    ArrayList<E> data;
    public ListQueue(){
        this.data = new ArrayList<>();
    }
    public void enqueue(E e){
        this.data.add(e);
    }
    public E dequeue(){
        if(!isEmpty()) {
            return this.data.remove(0);
        }
        return null;
    }
    public E peek(){
        if(!this.isEmpty()){
            return this.data.get(0);
        }
        return null;
    }
    public boolean isEmpty(){
        return this.data.size() == 0;
    }
}
