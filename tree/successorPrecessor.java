package tree;

/**
 */
public class successorPrecessor {
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

//    //no parent
//    public static TreeNode pre=null;
//    public static TreeNode suc=null;

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(20);
//        root.left.left=new TreeNode(4);
//
////        root.right.right = new TreeNode(10);
//        successorPrecessor(root, 4);
//
//        if(pre!=null) System.out.println("pre=" + pre.val);
//        else System.out.println("pre="+pre);
//
//        if(suc!=null) {
//            System.out.println("suc=" + suc.val);
//        }
//        else System.out.println("suc="+suc);
//    }
/*
    //no parent,从头开始，在进入子树之前，把pre，suc记录下来，当找到key后，如果当前root还有子树，就还要再进行寻找。
    static void successorPrecessor(TreeNode root,int key){
        //before go to right,update pre
        if(key>root.val){
            pre=root;
            successorPrecessor(root.right,key);
        }
        else if(key<root.val){
            suc = root;
            successorPrecessor(root.left,key);
        }
        //equal
        else{
            //go to rightmost of left subtree
            if(root.left!=null){
                pre=root.left;
                while(pre.right!=null){
                    pre=pre.right;
                }
            }
            //go to leftmost of right subtree
            if(root.right!=null){
                suc=root.right;
                while(suc.left!=null){
                    suc=suc.left;
                }
            }
        }
    }
    */

    //has parent
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
//        root.right = new TreeNode(20);
        root.left.left=new TreeNode(4);
        root.left.left.parent = root.left;
        root.left.parent = root;
//        root.right.parent=root;

//        root.right.right = new TreeNode(10);
        TreeNode res = findsuccessor(root, 10);

        if(res!=null) {
            System.out.println("res=" + res.val);
        }
        else System.out.println("res="+res);
    }
    static TreeNode findsuccessor(TreeNode root,int key){
//        if(root==null) return  null;
        if(key > root.val){
            return findsuccessor(root.right,key);
        }
        else if(key<root.val) return findsuccessor(root.left,key);
        //equal
        System.out.println(root.val);
        TreeNode suc=null;
        if(root.right!=null){
            suc=root.right;
            System.out.println(suc.val);
            while (suc.left!=null){
                suc=suc.left;
            }
            return suc;
        }
        else{
            suc=root;
            System.out.println("suc="+suc.val);
            while (suc!=null && suc.parent!=null && suc!=suc.parent.left){
                suc=suc.parent;
            }
            return (suc==null)? suc:suc.parent;
        }
    }
}
