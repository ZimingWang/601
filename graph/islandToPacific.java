package graph;

import java.util.HashMap;
import java.util.HashSet;

/** goolge
 * Created by lipingxiong on 11/25/15.
 * 第一题, 一个二维数组代表了一个岛. 周围都是海, 岛的左侧和上侧通向Pacific,
 * 右侧和下侧通向Atlantic. 每个数字都代表了那个位置的海拔高度. 现在下雨了,
 * 雨只有从海拔高的地儿能流向海拔低或者一样的地儿. 返回岛上的分水岭的点,
 * 就是在某个/某些点上, 雨水既能流进Pacific, 又能流向Atlantic.
 */
public class islandToPacific {
    // boolean[][] visited;
//    P记录是否能流向pacific，A记录是否能流向Atlantic
    HashMap<Integer,Boolean> P = new HashMap<>();
    HashMap<Integer,Boolean> A = new HashMap<>();
//    既能流进Pacific, 又能流向Atlantic 的点
    HashSet<Integer> res = new HashSet<>();
    int len = 0; //为了getIndex用

    public HashSet<Integer> peek(int[][] H){
        int m = H.length;
        int n = H[0].length;
        len = n;
//对每个点同时就行dfs，同时判断如果既能流进Pacific, 又能流向Atlantic，则加到结果
//        dfs的时候用一个flag来标记是判断P 还是 A
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                dfs(H,i,j,true);
                dfs(H,i,j,false);
                if(P.get(i*n+j) && A.get(i*n+j)){
                    res.add(i*n+j);
                }
            }
        }
//        输出最终结果
        for(int k:res){
            int row = k/len;
            int col = k%len;
            System.out.println(row + " " + col + " " + H[row][col]);
        }
        return res;
    }
    private boolean dfs(int[][] H, int i, int j, boolean isPacific){
        int m = H.length;
        int n = H[0].length;
        if(i<0 || i>=m ||j<0|| j>=n){
            return true;
        }
//        在边缘 的点都是能流向大洋的
        if(i==0  || j==0 ) {
            P.put(i*n+j,true);
        }
        if(i==m-1 || j==n-1){
            A.put(i*n+j,true);
        }

        if(isPacific){
//            DP，如果之前已经判断了，就直接放回；否则需要判断现在的点的海拔是否是比周围的高。
//            P的时候只检查左边和上边
            if (P.containsKey(getIndex(i,j))) return P.get( getIndex(i,j) );

            if(i>0 && H[i][j] >= H[i-1][j] && dfs(H,i-1,j, true)){
                P.put(getIndex(i,j), true);
            }
            else if(j>0 && H[i][j] >= H[i][j-1] && dfs(H, i, j-1, true)) {
                P.put(getIndex(i,j), true);
            }
            else{
                P.put(getIndex(i,j), false);
            }
//            A点时候判断右边和下边
        } else {
            if (A.containsKey(getIndex(i,j))) return A.get(getIndex(i,j));

            if(i <m-1 && H[i][j] >= H[i+1][j] && dfs(H,i+1,j,false)){
                A.put(getIndex(i,j) , true);
            }
            else if(j < n -1 && H[i][j] >= H[i][j+1] && dfs(H, i,j+1, false)){
                A.put(getIndex(i,j), true);
            } else {
                A.put(getIndex(i,j), false);
            }
        }
        return false;
    }
//    将row，col转换成一个整数，减少存储
    private int getIndex(int i, int j){
        return i*len + j;
    }
    public static void main(String[] args){
        islandToPacific ilp = new islandToPacific();
        int[][] H1 = new int[][]{
                {1,2,3},
        };
        int[][] H2 = new int[][]{
                {10,2,3},
                {3,5,8},
                {4,7,6},
        };
        int[][] H3 = new int[][]{
                {1,2,3},
                {2,5,4},
                {2,5,6},
        };
//        ilp.peek(H1);
        ilp.peek(H2);
    }
}
