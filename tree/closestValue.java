package tree;

/**
 * Created by lipingxiong on 8/27/15.
 */
public class closestValue {
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
    public int closestValue(TreeNode root, double target) {
        double closest = Math.abs(root.val - target);
        TreeNode cur = root;
        int value=0;
        while(cur!=null) {
            if(Math.abs(cur.val - target) < closest){
                closest = Math.abs(cur.val - target);
                value = cur.val;
            }
            if(target < cur.val){
                cur=cur.left;
            }
            else if(target > cur.val){
                cur = cur.right;
            }
            else break;
        }
        return value;
    }


}
