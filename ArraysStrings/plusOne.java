package ArraysStrings;

/**
 * Created by lipingxiong on 9/5/15.
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class plusOne {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            int tmp = digits[i] + carry;
            carry = tmp / 10; // update carry
            digits[i] = tmp % 10;
        }
        if(carry ==1 ){
            int[] res = new int[n+1];
            for(int i=0;i<n;i++){
                res[i+1]=digits[i];
            }
            res[0]=carry;
            return res;
        }
        else return digits;
    }
    public static void ptr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public  static void main(String args[]){
//        int[] res= plusOne(new int[]{9, 8});
//        ptr(res);
        System.out.println( addBinary("11","11") );
    }
    public static String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            sb.append((a.charAt(i)-'0' + b.charAt(j)-'0' + carry ) %2);
            carry = (a.charAt(i)-'0' + b.charAt(j)-'0' + carry ) / 2 ;
            i--;j--;
        }
        while(i>=0){
            sb.append( (a.charAt(i)-'0' + carry) % 2);
            carry = (a.charAt(i)-'0'+carry) / 2;
            i--;
        }
        while(j>=0){
            sb.append( (b.charAt(j)-'0'+carry) % 2) ;
            carry = (b.charAt(j)-'0' + carry) / 2;
            j--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(int e){
            this.val = e;
            this.next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode pre = l3;
        int carry = 0;
        while(l1!=null && l2!=null){
            int tmp= l1.val + l2.val + carry;
            ListNode node = new ListNode(tmp%10);
            carry = tmp / 10;
            pre.next = node;
            pre = pre.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int tmp = l1.val + carry;
            ListNode node = new ListNode( tmp % 10);
            carry = tmp / 10;
            pre = pre.next = node;
            l1=l1.next;

        }
        while(l2!=null){
            int tmp = l2.val + carry;
            ListNode node = new ListNode(tmp % 10);
            carry = tmp/10;
            pre = pre.next = node;
            l2=l2.next;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return l3.next;
    }

    }
