package tree;

/**
 * Created by lipingxiong on 10/27/15.
 */

public class populateNode {
    public static class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        TreeLinkNode(int x) {
            this.left =null;
            this.right = null;
            this.next  =null;
            this.val = x;
        }
    }
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;
        while(pre.left!=null){
            cur = pre;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null)cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}

