package tree;

/**
 * Created by lipingxiong on 10/15/15.
 */
public class diameterOfBST {
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
    int dia=0;

    public int diameter(TreeNode root){
        if(root==null) return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        dia = Math.max(lh+rh+1,dia);
        return Math.max(lh,rh)+1;
    }

    int maxSum=0;
    public int maxPathSum(TreeNode root){
        int L = maxPathSum(root.left);
        int R=maxPathSum(root.right);
        maxSum=Math.max((L+R+root.val), maxSum);
        return Math.max(L,R)+root.val;
    }
/*
5
  6
   7

5,7,3
 */
    public static void main(String[] args){
//        System.out.println(validPreorder(new int[]{5,7,3}));
//        System.out.println(validPreorder(new int[]{5,6,7}));
//        System.out.println(validPreorder(new int[]{10,5,3,7,20,12,30}));
        System.out.println(validPreorder(new int[]{10,5,3,7,20,30,12}));
    }

    public static boolean validPreorder(int[] arr){
        int n = arr.length;

        return validPreorder(arr,0,n-1);
    }
    public static boolean validPreorder(int[] arr, int l,int r){
        if(l>r) return true;
        int idx = l;
        int leftSize = 0;
        int rightSize = 0;
        int i = l+1;
        for(;i<=r;i++){
            if(arr[i] < arr[0]){
                leftSize ++ ;
                idx=i;
            }
        }
        boolean resL = validPreorder(arr,l+1,idx);
        if(resL==false) return false;
        boolean resR = validPreorder(arr,idx+1,r);
        if(resR==false) return false;
        if(idx < r) {
            for (int j = l+1; j <= r; j++) {
                if (arr[j] > arr[0]) {
                    rightSize++;
                }
            }
        }


        System.out.printf("leftSize=%d,rightSize=%d\n",leftSize,rightSize);

        if(leftSize + rightSize < r-l){
            return false;
        }
        else return true;

    }

}
