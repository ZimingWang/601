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
    ListNode cur=null;
    public TreeNode sortedListToBST(ListNode head) {
        cur=head;
        int n=0;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        return sortedListToBST(head,0,n-1);
    }
    /*
    先算出linklist的长度；然后将前半部分进行转换，
     */
    public TreeNode sortedListToBST(ListNode cur,int l,int r) {
        if(l>r) return null;
        int m = l+(r-l)/2;

        TreeNode left = sortedListToBST(cur,l,m-1);

        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.right = sortedListToBST(cur,m+1,r);
        return root;
    }


}
