package tree;
import tree.BTree.*;
/**
 * Created by lipingxiong on 11/6/15.
 */
public class longestConsecutive {
    public static void main(String[] args){
        TreeNode root = BTree.createTree(new int[]{1,2,3,4,5,6});
//        BTree.printNode(root);
        longestConsecutive l = new longestConsecutive();
        System.out.println(l.longestConsecutive(root));
    }
    int longest  =1 ;
    public int longestConsecutive(TreeNode root){
        if(root==null) return 0;
        longestConsecutive2(root);
        return longest;
    }
    public int longestConsecutive2(TreeNode root){
        if(root == null) return 0;
//        int longest  = 1;
        boolean flagL = false;
        boolean flagR = false;
        int resL = longestConsecutive2(root.left);
        int resR = longestConsecutive2(root.right);
        if(root.left != null && root.left.val - root.val == 1 ){
            longest = Math.max(longest,resL+1);
            flagL = true;
        }
        if(root.right != null && root.right.val - root.val == 1){
            longest = Math.max(longest,resR+1);
            flagL = true;
        }
        if(flagL==false && flagR==false) return 1;
        else if(flagL!=false && flagR != false){
            return Math.max(resL,resR) +1;
        }
        else {
            return  flagL==false ? resR+1 : resL+1;
        }
    }

}
