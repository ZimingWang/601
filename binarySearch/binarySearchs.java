package binarySearch;

/**
 * Created by lipingxiong on 10/29/15.
 */
public class binarySearchs {
    public static void main(String[] args){
//        findMin(new int[]{5,6,7,0,1,2,4});
//        findMin(new int[]{3,4,5,1,2});

//        System.out.println(search(new int[]{5, 6, 7, 0, 1, 2, 4}, 2));
//        System.out.println(search(new int[]{6, 6, 7}, 7));

//        System.out.println(searchInsert(new int[]{1,3,5,6},7));
//        searchRange(new int[]{5,7,8,8,10},7);
//        System.out.println(sqrt(10));
//        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
//        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 1}));
        System.out.println(findPeakElement(new int[]{1,2}));
    }
    public static int findPeakElement(int[] A) {
        int l=0;
        int r=A.length - 1;

        while(l<r){
            int m = l+(r-l)/2;
            System.out.printf("l=%d,m=%d,r=%d, A[l]=%d,A[m]=%d,A[r]=%d\n",l,m,r,A[l],A[m],A[r]);
            if(m==l) return A[m] > A[r] ? m : r; //only two elements
            if(A[m]> A[m-1] && A[m]>A[m+1] ) return m;
            if(A[m-1] > A[m]) r=m-1;
            else if(A[m+1] > A[m]) l=m+1;
        }
        System.out.printf("End: l=%d,r=%d\n",l,r);
        return l; //只有一个元素的时候会到这里
    }

    public static int sqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        int l=1;
        int r=x/2+1;

        while(l<=r)
        {
            int m = (l+r)/2;
            System.out.printf("l=%d,m=%d,r=%d\n",l,m,r);

            if(m<=x/m && x/(m+1)<m+1)
                return m;

            if(x/m<m)
            {
                r = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        return 0;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return  false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row=0;
        int col=n-1;

        while( row<m && col>=0) {
            if (target==matrix[row][col]) return true;
            else if(target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        //find the row
//        int l=0;
//        int r=m-1;
//        int mid=0;
//        while(l<=r){
//            mid =l+(r-l)/2;
//            if(matrix[mid][0]==target) return true;
//            else if (target<matrix[mid][0]) r=mid-1;
//            else l = mid+1;
//        }
//        int row = r;
//        if(row<0) return false;
//
//        l=0;r=n-1;
//        while(l<=r){
//            mid=l+(r-l)/2;
//            if(matrix[row][mid]==target) return true;
//            if(target < matrix[row][mid]) r=mid-1;
//            else l=mid+1;
//        }
//        return false;
//    }

    public static int[] searchRange(int[] A, int target) {
        //find left boiundary
        int l = 0,r=A.length-1,m=0;
        int left = -1,right=-1;
        while(l<=r){
            m = l+(r-l)/2;
            System.out.printf("l=%d,m=%d,r=%d, A[l]=%d,A[m]=%d,A[r]=%d\n",l,m,r,A[l],A[m],A[r]);
            if(A[m]<target){
                l=m+1;
            }
            else if (A[m] >= target)  r=m-1;
        }
        System.out.printf("End: l=%d,r=%d\n",l,r);
        left = l;

        l=0; r=A.length-1;
        while(l<=r){
            m = l+(r-l)/2;
            if(A[m]<=target) l=m+1; //equal, also go to right, we are looking for right boundary
            else r=m-1;
        }
        System.out.printf("End: l=%d,r=%d\n",l,r);
        right = r;

        System.out.printf("End: left=%d,right=%d\n",left,right);
        if(left > right) {left=-1; right=-1;}
        return new int[]{left,right};
    }

        public static int searchInsert(int[] A, int target ){
        int l = 0;
        int r = A.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            System.out.printf("l=%d,r=%d,m=%d,A[l]=%d,A[m]=%d,A[r]=%d\n",l,r,m,A[l],A[m],A[r]);
            if(A[m]==target){
                return m;
            }
            else if(A[m]<target)  {
                l=m+1;
            }
            else r = m-1;
        }
        System.out.printf("End: l=%d,r=%d\n",l,r);
        return l;
    }

//    Search in Rotated Sorted Array II
    public static boolean search(int[] A, int target) {
        int l = 0;
        int r = A.length-1;
        while(l <= r){
            int m = l + (r-l)/2;
            System.out.printf("l=%d,r=%d,m=%d,A[l]=%d,A[m]=%d,A[r]=%d\n",l,r,m,A[l],A[m],A[r]);
            if(A[m]==target) return true;

            if(A[l]<A[m]){ //left part sorted
                if(target>=A[l] && target<=A[m]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else if(A[l]>A[m]){ //right sorted
                if(A[m]<target && target<=A[r]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
            else{
                l++;
            }
        }
        System.out.printf("l=%d,r=%d\n",l,r);
        return false;
    }
//    Find min in Rotated Sorted Array II
    public static int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int l = 0;
        int r = num.length - 1;
        int min = num[0];
        while(l<r-1){
            int m = l + (r-l)/2;
            System.out.printf("l=%d,r=%d,m=%d,num[m]=%d\n",l,r,m,num[m]);
            if(num[l] < num[m]){//left part ordered
                min = Math.min(min,num[l]);
                l = m+1; //go to right part
            }
            else if(num[l] > num[m]){ //
                min = Math.min(min,num[m]);
                r = m-1;
            }
            else l++;

        }
        System.out.printf("l=%d,r=%d\n",l,r);
        min = Math.min(min,num[r]);
        min = Math.min(min,num[l]);
        System.out.println("min="+min);
        return min;
    }


}
