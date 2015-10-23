package tree;
import tree.BTree.*;
/**
 * Created by lipingxiong on 10/15/15.
 */
public class depthOfBST {
    public static void main(String[] args){
        TreeNode root=BTree.createTree(new int[]{0,3,7,30,35});

//        System.out.println(minDepth(root));
        System.out.println(closestValue(root,6));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        // if(root.left ==null && root.right ==null) return 1; 不需要这行
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)  return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

//    public static int closestValue(TreeNode root, double target){
//        return closestNode(root, target).val;
//    }
//    public static TreeNode closestNode(TreeNode root, double target) {
//        double closest= Math.abs(root.val-target);
//        System.out.println(closest +"root"+root.val);
////        if(root.left==null && root.right==null) return root;
//
//        if(target > root.val && root.right!=null){
//            TreeNode resR=closestNode(root.right, target);
//            System.out.println(resR.val+" resR");
//            if (Math.abs(resR.val-target) < Math.abs(closest) ){
//                return resR;
//            }
//        }
//        else if(target<root.val && root.left!=null){
//            TreeNode resL=closestNode(root.left, target);
//            if (Math.abs(resL.val-target) < Math.abs(closest) ){
//                return resL;
//            }
//        }
//       return root;
//
//    }

    public static int closestValue(TreeNode root, double target) {
        double closest = Math.abs(root.val - target);
        TreeNode cur = root;
        int value=root.val;

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
