package others;

/**
 * Created by lipingxiong on 10/1/15.
 */
public class mergeS {
    public void mergeS(int l,int r){
        if(l>=r) return ;
        int m = (l+r)/2;
        mergeS(l,m);
        mergeS(m+1,r);
        merge(l,r,m);
    }
    public void merge(int l,int r,int m){

    }
}
