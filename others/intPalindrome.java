package others;

/**
1, 123
 10, 12
 100, 1
 1000, 0
 */
public class intPalindrome {
//    Given an integer, determine if the integer is a palindrome or not..1point3acres缃�
//            12321
    public static boolean isPalindrom(int x){
        int fac = 1;

        while(fac<=x/10){
            fac*=10;
        }
//        System.out.println(fac);
        while(x!=0){
//            System.out.println(x+ " " +x/fac+" "+x%10);
//            System.out.println(x%10);
             if(x/fac != x%10){
                 return false;
             }
            x=(x%fac) /10 ;
//            System.out.println(x);
            fac = fac/100;
        }
        return true;
    }

    public static void main(String[] args){
//        System.out.println(isPalindrom(123));
        System.out.println(isPalindrom(1221));
//        System.out.println(isPalindrom(121));
        System.out.println(isPalindrom(100));
        System.out.println(isPalindrom(101));
    }

}
