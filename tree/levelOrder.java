package tree;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 11/16/15.
 */
public class levelOrder {
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args){
//        TreeNode root = BTree.createTree(new int[]{1,2,3,4,5});
        TreeNode root = BTree.createTree(new int[]{1});
        levelOrder(root,0);
        System.out.println(res);
    }
    public static void levelOrder(TreeNode root,int level){
        if(root ==null)return;
        if(res.size() == level){
            ArrayList<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(level).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right,level + 1);
//        return res;
    }
}