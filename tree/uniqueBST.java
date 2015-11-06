package tree;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class uniqueBST {
    public int numTrees(int n) {
        int[] t = new int[n+1];
        t[0]=1;
        t[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++) {
                t[i] += t[j - 1] * t[i - j];
            }
        }
        return t[n];
    }
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        if(start == end){
            TreeNode root = new TreeNode(start);
            res.add(root);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> list1 = generateTrees(start,i-1);
            List<TreeNode> list2 = generateTrees(i+1,end);

            for(TreeNode t1:list1){
                for(TreeNode t2:list2){
                    TreeNode root = new TreeNode(i);
                    root.left = t1;
                    root.right = t2;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

