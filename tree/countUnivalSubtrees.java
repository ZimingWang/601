package tree;

import DP.generateTree;

/**
 * Created by lipingxiong on 8/24/15.
 */
public class countUnivalSubtrees {
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

    public int countUnivalSubtrees(TreeNode root) {
        int[] count=new int[1];
        check(root,count);
        return count[0];
    }

    public boolean check(TreeNode root, int[] count) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            count[0] += 1;//the leaf is
            return true;
        }
        boolean l = check(root.left, count);
        boolean r = check(root.right, count);
        if(l && r){
//        if (check(root.left, count) && check(root.right, count)) { 、、不要用这样的，因为一旦前面一个条件失败了，后面的就不会执行了。
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            count[0] += 1;
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        countUnivalSubtrees ins=new countUnivalSubtrees();
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);

        System.out.println(ins.countUnivalSubtrees(root));
    }
}
