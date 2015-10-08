package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class generateTree {
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

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res= new ArrayList<>();
        if(start>end){
            res.add(null);//
            return res;
        }
        if(start==end) {
            res.add( new TreeNode(start) );
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> list1=generateTrees(start,i-1);
            List<TreeNode> list2=generateTrees(i+1,end);
            for(TreeNode l:list1){
                for(TreeNode r:list2){
                    TreeNode root= new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        generateTree gt= new generateTree();
        System.out.println(gt.generateTrees(3));
    }
}
