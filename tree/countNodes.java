package tree;

/**
 * Created by lipingxiong on 8/25/15.
 one node:
 5 root.right.h== n-1, 2<<n + root.right.c

n=1, root.right.h == n-1, 1<<n +
    1
 /   \
5    5

 5
 / \
 1   5
 / \   \
 5   5   5

 */
public class countNodes {
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

    private int height(TreeNode root){
        if(root == null) return -1;
        else return 1 + height(root.left);
    }
    public int countNodes(TreeNode root){
        int h = height(root);
        return h < 0 ? 0 :
            height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                    : (1 << h-1) + countNodes(root.left);
    }

}
