package tree;

import java.util.HashMap;

/**
 * Created by lipingxiong on 8/25/15.
 */
public class buildTree {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int n= preorder.length;
        return buildTree(map,preorder,inorder,0,n-1,0,n-1);
    }
    // 213
    //123, index = 1,   先序遍历是12453687，中序遍历是42516837。   index=3
    public static TreeNode buildTree(HashMap<Integer,Integer>map,int[] preorder, int[] inorder, int preL,int preR, int inL, int inR ){
        if(preL>preR || inL > inR) return null;
        TreeNode root= new TreeNode(preorder[preL]);
        int index = map.get(root.val);
//        int len = index - inL; //len of left tree;
        root.left = buildTree(map,preorder,inorder, preL+1, preL+index-inL,inL,index-1);
        root.right = buildTree(map,preorder,inorder, preL+index-inL+1,preR, index+1,inR );
        return root;
    }

    public static void main(String[] args){
        int[] preorder = new int[]{1,2,4,5,3,6,8,7};
        int[] inorder = new int[]{4,2,5,1,6,8,3,7};
        buildTree ins= new buildTree();
        System.out.println(ins.buildTree(preorder, inorder).val);
    }

}
