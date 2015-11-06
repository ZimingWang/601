package tree;

import java.util.Stack;
import tree.BTree.*;
/**
 */
public class preOrder {
    public static void main(String[] args){
        int[] preo = new int[]{10,5,2,4,3};

//        System.out.println(verifyPreorder(preo));
//        BTree.printNode( constructPreOrder(new int[]{10,5,6}) );
        BTree.printNode( constructPreOrder(new int[]{10,5,2,4,3}) );
    }
    public static boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low=Integer.MIN_VALUE;
        for(int i : preorder){
            if(i<low) return false;
            // pop out the ones that smaller than preorder[i]
            while(!stack.isEmpty() && i>stack.peek()){
                low=stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

    private static int index=0;

    public static TreeNode constructPreOrder(int[] pre,int index,int key,int min, int max){
        System.out.println("index"+index + "key=" + key +"min="+min + " max= "+ max);

        if(key<=min || key>=max) {
            index--;
            return null;
        }
        TreeNode root = new TreeNode(key);
        System.out.println("index"+index + "key=" + key );
        if(index+1 < pre.length) {
            index++;
            root.left = constructPreOrder(pre,index,pre[index],min,key);
            root.right = constructPreOrder(pre,index,pre[index],key,max);
        }
        return root;
    }

    public static TreeNode constructPreOrder(int[] pre){
        return constructPreOrder(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
