package graph;

import java.util.ArrayList;
import java.util.List;
import tree.*;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class dfss {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;

        TreeNode(int x) {
            this.left =null;
            this.right = null;
            this.parent  =null;
            this.val = x;
        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        rightSideView(root,res,0);
        return res;
    }

    public static void rightSideView(TreeNode root, ArrayList<Integer> res,int level){
        if(root==null) return;
        if(res.size() == level){
            res.add(root.val);
        }
        rightSideView(root.right,res, level+1);
        rightSideView(root.left,res,level+1);

    }
//    public static List<Integer> rightSideView(TreeNode root) {
//
//        ArrayList<Integer> res = new ArrayList<>();
//        if(root==null) return res;
//        res.add(root.val);
//        while(root!=null) {
//            System.out.println(root.val);
//            if (root.right != null) {
//                res.add(root.right.val);
//                root = root.right;
//            } else if(root.left!=null) {
//                res.add(root.left.val);
//                root = root.left;
//            }
//            else {
//                root=null;
//            }
//        }
//        return res;
//    }

}
