package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.BTree.*;

/**
 * Created by lipingxiong on 10/15/15.
 */
public class closestKValue {

    public static void main(String[] args){
        TreeNode root=BTree.createTree(new int[]{1,5,6,10,13,20});

//        System.out.println(minDepth(root));
        closestKValue ins =new closestKValue();
        System.out.println(ins.closestKValues(root,0.0,4));

    }

    public  List<Integer> closestKValues(TreeNode root,double target,int k){
        //find the cloest node for the target
//        TreeNode  clsNode = closestNode(root,target);
        List<Integer> res = new ArrayList<>();

        Stack<Integer> s1 = new Stack<>(); // predecessors
        Stack<Integer> s2 = new Stack<>(); // successors
        inorder(root,s1,target);
        postorder(root, s2, target);

        while(!s1.isEmpty() && !s2.isEmpty() && k>0){
            if(Math.abs(s1.peek()-target) < Math.abs(s2.peek()-target)){
                res.add(s1.pop());
            }
            else{
                res.add(s2.pop());
            }
            k--;
        }
        if(k<=0) return res;
        while(!s1.isEmpty()&&k>0){
            res.add(s1.pop());
            k--;
        }
        while(!s2.isEmpty()&&k>0){
            res.add(s2.pop());
            k--;
        }
        return res;
    }
    public void inorder(TreeNode root,Stack<Integer> stack,double target){
        if(root==null) return;
        inorder(root.left,stack,target);
        if(root.val > target) return;
        stack.push(root.val);
        inorder(root.right,stack,target);
    }
    public void postorder(TreeNode root, Stack<Integer>stack,double target){
        if(root==null) return;
        postorder(root.right,stack,target);
        if(root.val < target) return;
        stack.push(root.val);
        postorder(root.left,stack,target);
    }


}
