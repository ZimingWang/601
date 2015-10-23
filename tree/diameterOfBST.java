package tree;

/**
 * Created by lipingxiong on 10/15/15.
 */
public class diameterOfBST {
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
    int dia=0;

    public int diameter(TreeNode root){
        if(root==null) return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        dia = Math.max(lh+rh+1,dia);
        return Math.max(lh,rh)+1;
    }

    int maxSum=0;
    public int maxPathSum(TreeNode root){
        int L = maxPathSum(root.left);
        int R=maxPathSum(root.right);
        maxSum=Math.max((L+R+root.val), maxSum);
        return Math.max(L,R)+root.val;
    }


}
