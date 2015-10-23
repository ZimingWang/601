package tree;
import tree.BTree.*;
/**
 * Created by lipingxiong on 8/27/15.
 */
public class closestValue {

    public static void main(String[] args){
        TreeNode root=BTree.createTree(new int[]{0, 3, 7, 30, 35});

//        System.out.println(minDepth(root));
        System.out.println(closestValue(root, 34));
    }
// This is another which also works
//    public static int closestValue(TreeNode root, double target){
//        return closestNode(root,target).val;
//    }
//    public static TreeNode closestNode(TreeNode root, double target) {
//        double closest= Math.abs(root.val-target);
//        System.out.println(closest +"root"+root.val);
////        if(root.left==null && root.right==null) return root;
//
//        if(target > root.val && root.right!=null){
//            TreeNode resR=closestNode(root.right,target);
//            System.out.println(resR.val+" resR");
//            if (Math.abs(resR.val-target) < Math.abs(closest) ){
//                return resR;
//            }
//        }
//        else if(target<root.val && root.left!=null){
//            TreeNode resL=closestNode(root.left,target);
//            if (Math.abs(resL.val-target) < Math.abs(closest) ){
//                return resL;
//            }
//        }
//        return root;
//
//    }
    private static int closestValue(TreeNode root,double target){
        TreeNode node = closestNode(root,target);
        if(node==null)return -1;
        return node.val;
    }
    public static TreeNode closestNode(TreeNode root,double target){
        if(root==null)return null;
        TreeNode cur = root;
        TreeNode clsnode =root;
        double diff = Math.abs(root.val-target);
        while(cur!=null){
            if(cur.val==target) return  cur;
            if(Math.abs(cur.val-target) <diff ){
                diff=Math.abs(cur.val-target);
                clsnode=cur;
            }
            if(target > cur.val) cur=cur.right;
            else cur=cur.left;
        }
        return clsnode;
    }



}
