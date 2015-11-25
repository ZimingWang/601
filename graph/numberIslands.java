package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 11/19/15.
 */
public class numberIslands {
    public static void main(String[] args){
        numberIslands n = new numberIslands();
        int[][] A = new int[][]{{0,0},{0,1},{1,2},{2,1}};
        n.numIslands2(3, 3, A);
    }
    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        UnionFind2D uf = new UnionFind2D(m, n);

        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            System.out.println("position: x="+ x + " y="+ y);
            int p = uf.index(x, y);
            uf.add(x, y);
            com.com.ptrArr(uf.id);
            for (int[] d : dir) {
//                判断邻居是否标记过，如果是 就合并
                int q = uf.getId(x + d[0], y + d[1]);
                System.out.println("neighbours q=" + q);
//                q>0, 表示被标记过
                if (q > 0 &&  !uf.find(p, q)) {
                    uf.union(p, q);
                }
            }
            com.com.ptrArr(uf.id);
            res.add(uf.size());
        }
        System.out.println(res);
        return res;
    }
    class UnionFind2D {
        private int m;
        private int n;
        public int[] id;
        public int[] sz;
        public int count;

        UnionFind2D(int m, int n) {
            this.m = m;
            this.n = n;

//            id的第一位不用，也就是0 set是没有被标记的， 一旦被标记的，id[i] >0, 以此来区别是否执行过addLand operation。
            this.id = new int[m * n + 1];
            this.sz = new int[m * n + 1];
        }
        public int index(int x, int y) {
            if (0 <= x && x < m && 0 <= y && y < n) {
                //id的第一位不用，也就是0 set是没有被标记的, 所以其他的都往后移动一位
                return x * n + y + 1;
            }
            else {
                return 0;
            }
        }
        public int getId(int x, int y) {
            if (0 <= x && x < m && 0 <= y && y < n) {
                return id[index(x, y)];
            }
            else {
                return 0;
            }
        }
        public int add(int x, int y) {
            int i = index(x, y);
            id[i] = i;
            sz[i] = 1;
            count++;
            return i;
        }
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
        public void union(int p, int q) {
            System.out.println("union"+ p + " " + q);
            int i = root(p);
            int j = root(q);
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
            count--;
        }
        private int root(int i) {
            while (i != id[i]) {
                i = id[i];
            }
            return i;
        }
        public int size() {
            return count;
        }
    }
}
