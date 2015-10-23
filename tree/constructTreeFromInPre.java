package tree;

import java.util.HashMap;

/**
 * Created by lipingxiong on 10/17/15.
 */
//public class constructTreeFromInPre {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || inorder == null)
//            return null;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<inorder.length;i++){
//            map.put(inorder[i],i);
//        }
//        int n= preorder.length;
//        return buildTree(map,preorder,inorder,0,n-1,0,n-1);
//    }
//    // 213
//    //123, index = 1,   先序遍历是12453687，中序遍历是42516837。   index=3
//    public static TreeNode buildTree(HashMap<Integer,Integer> map,int[] preorder, int[] inorder, int preL,int preR, int inL, int inR ){
//
//        TreeNode root=new TreeNode(preorder[preL]);
//        int idx=map.get(preorder[0]);
//
//    }
//}
