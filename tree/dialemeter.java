package tree;

/**
 * Created by lipingxiong on 10/7/15.
 */
public class dialemeter {
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
    int res=0;
    int dialemeter(TreeNode root){
        if(root==null) return  0;
        int l = dialemeter(root.left);
        int r = dialemeter(root.right);
        res= l+r+1;
        return Math.max(l,r) +1;
    }

}
