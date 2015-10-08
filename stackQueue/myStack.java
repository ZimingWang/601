package stackQueue;

/**
 */
public class myStack<E> {
    public class Node<E>{
        Node next;
        E data;
        Node (E t){
            this.data = t;
        }
    }
   // Use Node
    Node<E> top;
    public E pop(){
        if(top == null) return null;
        else{
            E t = top.data;
            top = top.next;
            return t;
        }
    }
    void push(E t){
        Node item = new Node<E>(t);
        top.next = item;
        top = item;
    }
    E peek(){
        return top.data;
    }
}
