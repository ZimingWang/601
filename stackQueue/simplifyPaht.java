package stackQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by lipingxiong on 9/5/15.
 */
public class simplifyPaht {
    public static String simplifyPath(String path) {
//        "/home/"  "/home"
//  path = "/a/./b/../../c/", => "/c"
        LinkedList<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<String>();
        set.add(".");
        set.add("");
        for(String s:path.split("/")){
            if(s.equals("..") && !stack.isEmpty() ){
                stack.pop();
            }
            else if(set.contains(s)){
                ;
            }
            else {
                stack.push(s);
            }
        }
        String res = "";
        for(String s: stack){
            res = "/"+s+res;
        }
        return res;
    }

    public  static void main(String args[]){
        String path = "/a/./b/../../c/d";

        System.out.println(simplifyPath(path) );
        System.out.println(simplifyPath("/home/"));
    }
}
