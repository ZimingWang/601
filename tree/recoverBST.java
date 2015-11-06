package tree;

/**
 * Created by lipingxiong on 10/31/15.
 */
public class recoverBST {
    TreeNode p1;
    TreeNode p2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return  true;
        if(p==null || q==null) return  false;
        if(p.val != q.val) return false;
        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
