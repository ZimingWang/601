package tree;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class treeTemplate {

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
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }

    public static void binaryTreePaths(TreeNode root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer>item){
        if(root==null) return ;
        if(root.left==null && root.right==null){
            item.add(root.val);
            System.out.println("item:" + item);
            res.add(new ArrayList<Integer>(item));
            return;
        }

        item.add(root.val);
        binaryTreePaths(root.left, res, item);
        System.out.println(item);
        item.remove(item.size() - 1);

        item.add(root.val);
        binaryTreePaths(root.right,res,item);
        item.remove(item.size()-1);
    }





}
