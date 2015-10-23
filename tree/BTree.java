package tree;

/**
 * Created by lipingxiong on 10/15/15.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class BTreePrinterTest {


//}

//class TreeNode<T extends Comparable<?>> {
//    TreeNode left,right,parent;
//    T val;
//
//    public TreeNode(T val) {
//        this.val = val;
//    }
//}

class TreeNode {
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
class BTree {

    public static TreeNode createTree(int[] arr){
        TreeNode res = createTree(arr,0,arr.length-1);
        BTree.printNode(res);
        return res;
    }
    public static TreeNode createTree(int[] arr,int l,int r){
        if(l>r) return null;
        int m = l +(r-l)/2;
//        System.out.println(m);
        TreeNode root = new TreeNode(arr[m]);
        root.left = createTree(arr,l,m-1);
        root.right = createTree(arr,m+1,r);
        return root;
    }

    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTree.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTree.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTree.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTree.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTree.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTree.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTree.printWhitespaces(1);

                BTree.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTree.printWhitespaces(1);

                BTree.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTree.maxLevel(node.left), BTree.maxLevel(node.right)) + 1;
    }

    private static  boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    private static TreeNode test1() {
        TreeNode root = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(6);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(8);
        TreeNode n33 = new TreeNode(4);
        TreeNode n34 = new TreeNode(5);
        TreeNode n35 = new TreeNode(8);
        TreeNode n36 = new TreeNode(4);
        TreeNode n37 = new TreeNode(5);
        TreeNode n38 = new TreeNode(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static TreeNode test2() {
        TreeNode root = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(9);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(8);
        TreeNode n33 = new TreeNode(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root =BTree.createTree(new int[]{1,2,3,4,5,6});
        BTree.printNode(root);

//        BTree.printNode(test1());
//        BTree.printNode(test2());

    }


}
