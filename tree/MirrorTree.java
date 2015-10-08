package tree;

/**
 * Created by lipingxiong on 9/18/15.
 */
//http://www.crazyforcode.com/mirror-image-binary-tree/
public class MirrorTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public Node mirror(Node root){
        if(root == null || root.left==null && root.right==null) return root;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
    public void mirror2(Node root){
        print(root);
        Node x = mirrorTree(root);
        System.out.print("\n Mirror Image ");
        print(x);
    }
    public Node mirrorTree(Node root){
        if(root!=null){
            Node t = root.left;
            root.left = root.right;
            root.right = t;
            mirrorTree(root.right);
            mirrorTree(root.left);
        }
        return root;
    }
    public void print(Node root){
        if(root!=null){
            print(root.left);
            System.out.print(" " + root.data);
            print(root.right);
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        MirrorTree i  = new MirrorTree();
        i.mirror(root);
    }
}


