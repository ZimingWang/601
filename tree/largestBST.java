package tree;

/**
 * Created by lipingxiong on 10/7/15.
 */
public class largestBST {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        boolean isBST;

        TreeNode(int x) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.val = x;
            isBST = false;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(9);
////        root.right.right = new TreeNode(10);
//        TreeNode res = lgBST2(root,new int[1]);
//
//        System.out.println(res.val);

		/*
		 1
		/ \
	   2   3
	   / \
	  1   5
////	  */
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(5);
//        int[] size = new int[1];
//        size[0]=0;
//        TreeNode res = lgBST2(root,size);
//        System.out.println(res.val);
//        System.out.println("size="+size[0]);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(6);
//        root.left.right.right.right = new TreeNode(7);
//        int[] size = new int[1];
//        size[0]=0;
//        TreeNode res = lgBST2(root,size);
//        System.out.println(res.val);
//        System.out.println("size="+size[0]);

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(20);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(6);
//        root.left.right.right.right = new TreeNode(7);
        int[] size = new int[1];
        size[0]=0;
        TreeNode res = lgBST2(root,size);
        System.out.println(res.val);
        System.out.println("size="+size[0]);

    }

//    }
//    class Res{
//        int size;
//        TreeNode root;
//    }

//    boolean isBST(TreeNode root){
//        return true;
//    }
//    Res lgBST(TreeNode root){
//        if(isBST(root))return root;
//        Res left = lgBST(root.left);
//        Res right = lgBST(root.right);
//        if(left.size > right.size){
//            return left;
//        }
//        else return right;
//    }


    static TreeNode lgBST2(TreeNode root, int[] size ) {
        if(root==null) {
            size[0]=0;
            return root;
        }
//        叶子都是BST，而且size=1
        if (root.left == null && root.right == null) {
            root.isBST = true;
            size[0]=1;
            return root;
        }
        TreeNode resL = null;
        TreeNode resR = null;
        int[] sizeL = new int[1];
        sizeL[0] = 0;
        int[] sizeR = new int[1];
        sizeR[0]=0;
//        分别算左边和右边，并且记录各自最大BST的size，后面要用这个来判断哪个大
        resL = lgBST2(root.left,sizeL);
        resR = lgBST2(root.right,sizeR);

//        左子树null，判断右边子树能否和root构成一颗BST，能的话就返回root，否则就返回resR（右子树中最大BST）
//
        if (resL == null) {
            if(root.right.isBST && root.val<root.right.val) {
                root.isBST=true; //remember to update root's status
                size[0]= sizeR[0]+1; //don't forget to update size
                return root;}
            return resR; //can't construct new BST with root, just return resR
        }
        if (resR == null){
            if(root.left.isBST && root.left.val<root.val) {
                root.isBST=true;
                size[0]=sizeL[0]+1;
                return root;}
            return resL;
        }

        //both not null,check if new BST can be constructed when we add root
        if( (root.left.isBST && root.right.isBST)
            &&(root.left.val < root.val && root.val < root.right.val)
        ){
                root.isBST = true;
                size[0]=sizeL[0] + sizeR[0]+1;
                return root;
        }
        //which one is larger?
        else {
            root.isBST = false;
            if(sizeL[0]>sizeR[0]) {
                size[0]=sizeL[0];
                return resL;
            }
            else {
                size[0]=sizeR[0];
                return resR;
            }
        }

    }




}
