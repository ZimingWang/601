package tree;
import tree.BTree.*;
/**
 * Created by lipingxiong on 10/15/15.
 */
public class largestBST_2 {

    class MinMax{
        int min;
        int max;
        int size;
        boolean isBST;
        MinMax(){
            this.min = 0;
            this.max=0;
            this.size=0;
            this.isBST=false;
        }
        public void print(){
            System.out.println(min+" "+" "+max+" "+size+" "+isBST);
        }

    }

    int max=0;
    private TreeNode lgBST=null;

    public static void main(String[] args){
        TreeNode root=null;
        root=BTree.createTree(new int[]{1,4,3,2,4,6});
        largestBST_2 ins = new largestBST_2();
        ins.largest(root);
        System.out.println(ins.max+" "+ins.lgBST.val);
    }
    public  MinMax largest(TreeNode root){
        if(root ==null) return null;
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax = largest(root.right);
        if(leftMinMax!=null)leftMinMax.print();
        if(rightMinMax!=null)rightMinMax.print();
        MinMax m = new MinMax();
        if(leftMinMax!=null && rightMinMax!=null && root.val>leftMinMax.max && root.val < rightMinMax.min){
            m.min=leftMinMax.min;
            m.max = rightMinMax.max;
            m.isBST=true;
            m.size = leftMinMax.size + rightMinMax.size+1;
        }
        if(leftMinMax==null && rightMinMax==null){
            m.min=root.val;
            m.max=root.val;
            m.size=1;
            m.isBST=true;
        }
        else if(leftMinMax == null){
            if(rightMinMax.min > root.val ){
                m.max = rightMinMax.min;
                m.min = root.val;
                m.isBST = true;
                m.size += rightMinMax.size + 1;
            }
        }
        else if(rightMinMax==null){
            if(leftMinMax.max < root.val){
                m.max=root.val;
                m.min = leftMinMax.max;
                m.isBST=true;
                m.size=leftMinMax.size+1;
            }
        }
        m.print();
        if(m.isBST && m.size>max) {
            max=m.size;
            lgBST=root;
        }
        return m;
    }
}
