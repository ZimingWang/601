package sort;
/**
 * Created by lipingxiong on 8/24/15.
 */
/* The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
01221
01122
    */
public class sortColors {
//    public void sortColors(int[] A) {
//        int l=0;
//        int r=A.length-1;
//        for(int i=0;i<=r;i++){
//            if(A[i]==2 && i<r){
////                swap(A[i],A[r--]);
//            }
//            else if(A[i]==0 && i>l){
////                swap(A[l++],A[i]);
//            }
//        }
//    }

    public static void main(String[] args){
////        sortABC(new char[]{'b','a','c'});
//        String s = "cbbabbabca";
//        char[] data = s.toCharArray();
//        sortABC(data);
//        String s = "1120";
        sortColors(new int[]{1,2,0});
    }
/*
1,2,0
1,0,2
0,1,2

0
 */

    public static void sortColors(int[] data){
        int p0=0;int p2=data.length-1;

        for(int i=0;i<=p2;i++){
            while(data[i]==2 && i<p2){
                swap(data,i,p2);
                p2--;
            }
            while(data[i]==0 && p0<i) {
                swap(data,p0,i);
                p0++;
            }

        }
        com.com.ptrArr(data);
    }
//    public static void sortColors(int[] data){
//        com.com.ptrArr(data);
//        int n = data.length ;
//        int p1=0,p2=0,p3=n-1;
//
//        while(p2 < n ){
//            System.out.printf("p1=%d,p2=%d,p3=%d,cur=%d\n",p1,p2,p3,data[p2]);
//            if(data[p2]==1){
//                p2++;
//                continue;
//            }
//            else if(data[p2]==0){
//                swap(data,p1,p2);
//                p1++;
//                p2++;
//            }
//            else{
//                while( p3>=p2 && data[p3]==2)p3--;
//                if(p3<p2)break;
//                swap(data,p2,p3); //2 <-> non 2
//                if(data[p2]==0){
//                    swap(data,p1,p2);
//                    p1++;
//                    p2++;
//                }
//                else p2++;
//            }
//        }
//        com.com.ptrArr(data);
//    }

    public static void swap(int[] data,int i,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
//
//    public static void sortABC(char[] data){
//        ptrChar(data);
//        int n = data.length;
//        int p1=0;//first index of b
//        int p2=0; //cur poninter
//        int p3=n-1; //first non c
//
//        while(p2!=p3){
//            System.out.printf("p1=%d,p2=%d,p3=%d,cur=%s\n",p1,p2,p3,data[p2]);
//            if(data[p2]=='b'){
//                p2++;
//                continue;
//            }
//            else if(data[p2] == 'a'){
//                swap(data,p1,p2);
//                p1++;
//                p2++;
//            }
//            else {
//                while(p3>=p2 && data[p3]=='c') p3--;
//                if(p3<p2) break;
//                swap(data,p2,p3);  // swap 'c' and first non c
//                if(data[p2]=='a'){ //after swap, it 'a'
//                    swap(data,p1,p2);
//                    p1++;
//                    p2++;
//                }
//                p2++;
//            }
//        }
//        ptrChar(data);
//    }
//    public static void swap(char[] data,int i,int j){
//        char tmp = data[i];
//        data[i] = data[j];
//        data[j] = tmp;
//    }
//    public static void ptrChar(char[] arr){
//        for(char ch:arr) {
//            System.out.print(ch+" ");
//        }
//        System.out.println();
//    }
}
