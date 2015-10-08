package tree;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class kthSmallest {
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        kthSmallest(root,3);
    }

//    int k=0;
    public static int kthSmallest(TreeNode root, int k) {
        TreeNode res = kthSmallest(root,k,new int[1]);
        System.out.println(res.val);
        return  res.val;
    }
    private static TreeNode kthSmallest(TreeNode root, int k, int[] A) {
        if (root == null) return null;
        TreeNode res=kthSmallest(root.left, k, A );
        if(res!=null) return res;
        A[0]+=1;
        if(A[0]==k) return root;
        return kthSmallest(root.right,k, A);
    }

}
