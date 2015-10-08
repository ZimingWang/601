package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipingxiong on 8/25/15.
 */
public class zigzagLevel {

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

//    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int level = 1;
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(root.val);
        res.add(item);
        stack.push(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> newStack = new LinkedList<TreeNode>();
            item = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (level % 2 == 0) {
                    if (node.left != null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                    if (node.right != null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                } else {
                    if (node.right != null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                    if (node.left != null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                }
            }
            level++;
            if (item.size() > 0)
                res.add(item);
            stack = newStack;
        }
        return res;
    }

    public static void main(String[] args){
        zigzagLevel  ins = new zigzagLevel();
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right =new TreeNode(20);
        System.out.println(ins.zigzagLevelOrder(root));
    }
}
