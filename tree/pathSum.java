package tree;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 8/20/15.
 */
public class pathSum {
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
    /*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,

            5
            / \
            4   8
            /   / \
            11  13  4
            /  \    / \
            7   2  5   1
            return

            [
            [5,4,11,2],
            [5,8,4,5]
            ]
            */
    /*
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
//        root.right.left = new

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        pathSum2(root,22,res, new ArrayList<Integer>());
        System.out.println(res);
    }
    */
    /*
    7 No, then change to 2
     */
    //Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    public static void pathSum2(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer>item){
        if(root == null) return;

        if(root.left==null && root.right==null && sum==root.val){
            item.add(root.val);
            res.add( new ArrayList<Integer>(item) );
            item = new ArrayList<>();
        }
        item.add(root.val);
        pathSum2(root.left, sum-root.val, res, item);
        item.remove(item.size() - 1);

        item.add(root.val);
        pathSum2(root.right, sum-root.val, res, item);
        item.remove(item.size() - 1);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.left.right = new TreeNode(2);
//        root.right.left = new

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        pathSum2(root,9,res, new ArrayList<Integer>());
        System.out.println(res);
    }
/*
            5
            / \
            4   8
            /   / \
            11  13  4
            /  \    / \
            7   2  5   1
[5,4];
[5,4,

*/
    /*
    path[0]=5
    path[1]=4
    path[2]=11
    path[3]=7
    */

// must start at root,  can end anywhere
    public static void pathSum3(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer>item){
        if(root==null) return ;
        item.add(root.val);
        if(root.val == sum){
            res.add(new ArrayList<Integer>(item));
//            item = new ArrayList<>();
        }
        else {
//            item.add(root.val);
            pathSum3(root.left, sum, res, item);
//            item.remove(item.size() - 1);
        }

    }

}
