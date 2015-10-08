package tree;

/**
 * Created by lipingxiong on 8/25/15.
 */
public class flatten {

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

    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while(root!=null){
            if(cur.left!=null){
                TreeNode last=cur.left;
                while(last.right!=null) last=last.right;
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur=cur.right;
        }
    }
}
