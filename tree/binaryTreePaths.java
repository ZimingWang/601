package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class binaryTreePaths {
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
        System.out.println(binaryTreePaths(root));
    }
    public static List<String>  binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<String>();
        if(root ==null) res.add("");
        searchBT(root,new String(),res);
        return res;
    }
    public static void searchBT(TreeNode root ,String path, List<String> res){
        if(root.left==null && root.right==null) res.add(path+root.val);
        if(root.left!=null) searchBT(root.left, path + root.val + "->", res);
        if(root.right!=null) searchBT(root.right, path + root.val + "->", res);
    }

}


