/**
 * Created by lipingxiong on 8/13/15.
 */
//package sort
public class insertionSort {
        public static void main( String[] args){
            int[] A={3,4,2};
            insertionSort(A);
            for(int e:A){
                System.out.print(e);
            }
        }
        public static void insertionSort(int[] A){
            int value;
            for(int i=1;i<A.length;i++){
                System.out.println("i="+i);
                value = A[i];
                int j = i-1;
                for(j=i-1;j>=0;j--){

                    if( A[j] > value ){
                        System.out.println("j="+j);
                        A[j+1]=A[j];
                    }
                    else{
                        break;
                    }
                }
                A[j+1] = value;
            }
        }
}

