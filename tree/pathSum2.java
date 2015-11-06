package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 10/31/15.
 */
public class pathSum2 {

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(pathSum(root, 3));

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        ArrayList<Integer> item = new ArrayList<>();
//        item.add(root.val);
        helper(root, sum, item, res);
        return res;
    }
    public static void helper(TreeNode root,int sum,ArrayList<Integer> item,List<List<Integer>> res) {
        if (root == null) return;
        item.add(root.val);
        if (sum == root.val && root.left ==null && root.right == null) {

            res.add(new ArrayList<Integer>(item));
        }
        if(root.left != null) {
            helper(root.left,sum-root.val,item,res);
            item.remove(item.size() - 1);
        }
        if(root.right != null) {
            helper(root.right,sum-root.val,item,res);
            item.remove(item.size() - 1);
        }
    }
}
