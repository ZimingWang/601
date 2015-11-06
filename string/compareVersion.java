package string;

import javax.swing.event.MouseInputListener;

/**
 */
public class compareVersion {
    public static void main(String[] args){
//        System.out.println(compareVersion("1.0.0.0","1") );
//        System.out.println(compareVersion("1","1.0.0") );
//        System.out.println(compareVersion("1.0","2") );
        System.out.println(compareVersion("","1") );
        System.out.println(compareVersion("12","") );
    }
    public static int compareVersion(String version1, String version2) {
//        0.1 < 1.1 < 1.2 < 13.37
        if(version1.length()==0 && version2.length()==0) return 0;
        else if (version1.length()==0 && version2.length() > 0) return -1;
        else if (version2.length() == 0 && version1.length() > 0) return 1;

        String[] arr1=version1.split("\\.");
        String[] arr2=version2.split("\\.");
        int minLen=Math.min(arr1.length, arr2.length);
        int i=0;
        for(;i<minLen;i++){
            if(Integer.parseInt(arr1[i]) >  Integer.parseInt(arr2[i])){
                return 1;
            }
            else if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return -1;
            }
            else{
                continue;
            }
        }
        if(i==arr1.length && i==arr2.length) return 0;
        else if(i==arr1.length){
            while(i<arr2.length && Integer.parseInt(arr2[i]) == 0)i++;
            if(i==arr2.length) return 0;
            else return -1;
        }
        else {
            while(i<arr1.length && Integer.parseInt(arr1[i])==0)i++;
            if(i==arr1.length) return 0;
            else return 1;
        }
    }
}
