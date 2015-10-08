package tree;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

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
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    /*
    I directly return where the pointer pointing at, which should be the left most TreeNode I previously found.
     What to do next? After returning the smallest TreeNode, I need to point the pointer to the next smallest TreeNode.
     */
    public int next() {
        TreeNode top = stack.pop();
        if(top.right!=null){
            TreeNode cur = top;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
        }
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */