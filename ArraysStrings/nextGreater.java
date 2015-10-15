package ArraysStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipingxiong on 10/9/15.
 * 4,5,2,1 25
 */
public class nextGreater {
    public static void main(String[] args){
        nextGreater ng = new nextGreater();
//        ng.nextGreater(new int[]{3,1,5,2,1,0});
        ng.nextGreater(new int[]{4,5,2,1,25});
    }
    public ArrayList<Integer> nextGreater(int[] arr){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=stack.peek()) { //<= just push
                stack.push(arr[i]);
                continue;
            }
            //remembeer to check stack is empty,
            while( !stack.isEmpty() && arr[i] > stack.peek()) {
                int top = stack.pop();
                res.add(arr[i]);
            }
            stack.push(arr[i]);

        }
        while(!stack.isEmpty()) {
            stack.pop();
            res.add(-1);
        }
        for(int e:res){
            System.out.println(e);
        }
        return res;
    }
}

/*
4
5,
5,2,1
25
 */