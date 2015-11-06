package tree;

/**
 * Created by lipingxiong on 10/7/15.
 */
public class dialemeter {

    int longest=0;
//    int dialemeter(TreeNode root){
//        if(root==null) return  0;
//        int l = dialemeter(root.left);
//        int r = dialemeter(root.right);
//        res= l+r+1;
//        return Math.max(l,r) +1;
//    }
    public int diameter(TreeNode root){
        if(root==null) return 0;
        int resL = diameter(root.left);
        int resR = diameter(root.right);
        longest = Math.max(longest ,resL+resR + 1 );
        return Math.max(resL, resR) + 1;
    }
}
