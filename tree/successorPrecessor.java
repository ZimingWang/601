package tree;

import tree.BTree.*;

/**
 */
public class successorPrecessor {

//    //no parent
    public static TreeNode pre=null;
    public static TreeNode suc=null;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left=new TreeNode(4);

//        BTree.printNode(root);
//        root.right.right = new TreeNode(10);
        TreeNode root2 = BTree.createTree(new int[]{1,2,3,4,5});
        BTree.printNode(root2);
        successorPrecessor(root2, 2);

        if(pre!=null) System.out.println("pre=" + pre.val);
        else System.out.println("pre="+pre);

        if(suc!=null) {
            System.out.println("suc=" + suc.val);
        }
        else System.out.println("suc="+suc);
    }


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

    // 把pre，suc当参数这样传是不行的，这是值传递，没办法把新的值往回传
//    static void successorPrecessor(TreeNode root,int key,TreeNode pre,TreeNode suc){
//        //before go to right,update pre
//        if(key>root.val){
//            pre=root;
//            successorPrecessor(root.right,key,pre,suc);
//        }
//        else if(key<root.val){
//            suc = root;
//            successorPrecessor(root.left,key,pre,suc);
//        }
//        //equal
//        else{
//            //go to rightmost of left subtree
//            if(root.left!=null){
//                pre=root.left;
//                while(pre.right!=null){
//                    pre=pre.right;
//                }
//            }
//            //go to leftmost of right subtree
//            if(root.right!=null){
//                suc=root.right;
//                while(suc.left!=null){
//                    suc=suc.left;
//                }
//            }
//        }
//    }


    //has parent
    TreeNode getSuccessor(TreeNode node){
        if(node==null)return null;

        if(node.right!=null){
            TreeNode cur = node.right;
            while(cur.left!=null){
                cur=cur.left;
            }
            return cur;
        }
        else{
            TreeNode pa = node.parent;
            TreeNode cur = node;
            while(pa!=null && cur!=pa.left){
                cur = pa;
                pa=pa.parent;
            }
            return pa;// will be null if no suc
        }
    }

    TreeNode getPredecessor(TreeNode node){
        if(node==null) return null;
        if(node.left!=null){
            TreeNode cur=node.left;
            while(cur.right!=null){
                cur=cur.right;
            }
            return cur;
        }
        else{
            TreeNode pa = node.parent;
            TreeNode cur = node;
            while(pa!=null && cur!=pa.right){
                cur=pa;
                pa=pa.parent;
            }
            return pa;
        }
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
