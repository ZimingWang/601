package tree;

/**
 * Created by lipingxiong on 8/17/15.
 */
public class LCA2 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.left = null;
            this.right = null;
            this.val = x;
        }
    }
    private static boolean search(TreeNode root, TreeNode p){
        if (root ==null) return false;
        if(root.val == p.val) return true;
        return search(root.left,p)|| search(root.right, p);
    }
    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root.val == p.val || root.val == q.val) return root;
        boolean is_p_on_left = search(root,p);
        boolean is_q_on_left = search(root, q);
        // p and q are on diff sides
        if(is_p_on_left != is_q_on_left) return root;
        //both on left,LCA(root.left),
        TreeNode side = (is_p_on_left) ? root.left: root.right;
        return LCA(side,p,q);

    }

}
