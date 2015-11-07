package tree;
import tree.BTree.*;
/**
 * Created by lipingxiong on 11/6/15.
 * subtree为空，用null表示，递归进行。
 * deserialize的时候也是递归，先将string 转成array，然后一个一个进行，按preorder的顺序，
 * 下root，然后left，right。 用index【】 来记录当前处理到array的哪个位置，因为不能用global，而且java中是值传递
 */
public class SerializeDeserializeBT {
    public static void main(String[] args){
        TreeNode root = BTree.createTree(new int[]{1,2,3,4,5});
        Codec c = new Codec();
        String res = c.serialize(root);
        System.out.println(res);
        TreeNode node = c.deserialize(res);
        BTree.printNode(node);
    }

    public static class Codec {

        // Encodes a tree to a single string.

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root,sb);
            return sb.toString();
        }
        public void serialize(TreeNode root, StringBuilder sb) {
            if(root == null) {
                sb.append("null,");
                return ;
            }
            sb.append(root.val+",");
            serialize(root.left,sb);
            serialize(root.right,sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            TreeNode root = deserialize(arr, new int[]{0});
            return root;
        }

        public TreeNode deserialize(String[] arr, int[] index) {
            TreeNode root = null;
            int idx = index[0];
//            if()
            if(arr[idx].equals("null")){
                index[0] = index[0]+1;
                return null;
            }
            root = new TreeNode(Integer.parseInt(arr[idx]));
            index[0] = index[0]+1;
            root.left = deserialize(arr, index);
            root.right = deserialize(arr, index);
            return root;
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
