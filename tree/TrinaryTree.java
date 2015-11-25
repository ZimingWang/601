package tree;

/**
 * Created by lipingxiong on 11/21/15.
 */
public class TrinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 9, 5, 7, 2, 2};

        TrinaryTree tree = new TrinaryTree();
        Node root = tree.BuildTree(arr);

        tree.Delete(root,5);
        tree.Print(root);

        tree.Delete(root,5);
        tree.Print(root);

//        tree.Delete(root,9);
//        tree.Print(root);
    }
    class Node {
        int value;
        Node left;
        Node middle;
        Node right;
        Node(int value){
            this.value = value;
            this.left = null;
            this.middle = null;
            this.right = null;
        }
    }
    Node root;
    TrinaryTree() {
        root = null;
    }
    // build a tri-nary tree from a array of numbers
    public Node BuildTree(int[] arr) {
        root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++)
        {
            Insert(root, arr[i]); // add to the tree one by one
        }
        Print(root);
        return root;
    }

    /**
     * Insert a value to a tree rooted at "node". Basic idea is:
     * Comparing the value with node.value, then decide either recursively insert to left or mid or right.
     * @param node root
     * @param value the value to be inserted
     */
    public void Insert(Node node, int value){
        if (value < node.value) {
           if (node.left == null) {
               node.left = new Node(value);
           } else {
               Insert(node.left, value);
           }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                Insert(node.right, value);
            }
        } else {
            if (node.middle == null) {
                node.middle = new Node(value);
            } else {
                Insert(node.middle,value);
            }
        }
    }

    /**
     * Delete a node whose value is equal to value.
     * @param node
     * @param value
     * @return the deleted node
     */

    public Node Delete(Node node, int value) {
        if (node == null) return null;
        if (value < node.value) {
            node.left  = Delete(node.left, value);
        } else if (value > node.value) {
            node.right = Delete(node.right, value);
        } else {
            if (node.middle != null) {
                node.middle = Delete(node.middle, value);
            } else if (node.right != null) {
                Node leftmost = getLeftMost(node.right);
                node.value = leftmost.value;
                node.right = Delete(node.right, leftmost.value);
            } else {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * Get left most node
     * @param node root of this subtree
     * @return
     */
    private Node getLeftMost(Node node) {
        Node cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /**
     * Helper function used for test
     * @param root
     */

    public void Print(Node root){
        Print(root,"root");
        System.out.println();
    }

    public void Print(Node root,String direction) {
        if(root == null) return;
        System.out.println(direction + " " + root.value);
        Print(root.left,"left");
        Print(root.middle,"mid");
        Print(root.right,"right");
    }
}
