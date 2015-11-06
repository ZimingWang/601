package com;
/**
 * Created by lipingxiong on 10/16/15.
 */
public class com {
    public static void ptrArr(int[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + " ");
        }
        System.out.println();
    }
    public static void ptrStr(String[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + ",");
        }
        System.out.println();
        System.out.println("len="+num.length);
    }
}
