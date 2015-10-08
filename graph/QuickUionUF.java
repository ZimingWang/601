package graph;

/**
 * Created by lipingxiong on 9/11/15.
 */
public class QuickUionUF {
    private int[] id;
    public QuickUionUF(int N){
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }
    private int root(int i){
        while(id[i]!=i) i=id[i];
        return i;
    }
    public boolean connect(int p, int q){
        return root(p) == root(q);
    }
    public void union(int p,int q){
        id[p] = root(q);
    }
    public class quickFindUF{
        private int[] id;
        public quickFindUF(int N){
            id = new int[N];
            for(int i=0;i<N;i++){
                id[i] = i;
            }
        }
        public boolean connected(int p, int q){
            return id[p] == id[q];
        }
        public void union(int p,int q){
            int pid=id[p];
            int qid=id[q];

        }
    }
//    public boolean validTree(int n, int[][] edges) {

//    }

}

