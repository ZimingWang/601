package tree;

/**
 * Created by lipingxiong on 9/6/15.
 */
public class sortedList2BST {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int x){
            val =x;
        }
    }
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




}
