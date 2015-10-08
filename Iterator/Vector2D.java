package Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class Vector2D {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    Vector2D(List<List<Integer>> vec2d){
        i=vec2d.iterator();
    }
    public int next(){
        hasNext();
        return j.next();
    }
    public boolean hasNext(){
        if( ( j==null|| !j.hasNext()) && i.hasNext()){
            j=i.next().iterator();
        }
        return j!=null && j.hasNext();
    }
}
