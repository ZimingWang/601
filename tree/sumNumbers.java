package tree;

/**
 * Created by lipingxiong on 8/24/15.
 */
public class sumNumbers {
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
    2
         1
        / \
        2  3
     */

    public int sumNumbers(TreeNode root) {
        //sum: sum from parent nodes in the path
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int sum){
        if(root==null)return 0;
        // 10 times sum computed from parents on this path,plus root.val as
        // the sum till this node.
        sum = sum*10+root.val;
        // leaf node,stop this path
        if(root.left==null && root.right ==null){
            return sum;
        }
        // Not leaf node, continue to go deep
        return sumNumbers(root.left,sum) + sumNumbers(root.right,sum);
    }

}
