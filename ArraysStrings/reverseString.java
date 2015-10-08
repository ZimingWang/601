package ArraysStrings;

/**
 * Created by lipingxiong on 8/27/15.
 */
public class reverseString {
    public static String reverseWord(String s){
        if(s==null || s.length()==0) return s;
        s.trim();
        StringBuilder sb = new StringBuilder();
        // reverse whole string, del spaces, x x__xx
        for(int i=s.length()-1;i>=0;i--){
            while(s.charAt(i) == ' ' && s.charAt(i)==s.charAt(i-1)) continue;;
            sb.append(s.charAt(i));
        }
        //reverse each word
        int l=0;
        int r=0;
        int next =0;
        while(r < sb.length()){
            //move r, so that
            while(r<sb.length() && sb.charAt(r)!=' '){
                r++;
            }
            next = r+1;
            r--;
            while(l<r){
                char tmp = sb.charAt(l);
                sb.setCharAt(l++, sb.charAt(r));
                sb.setCharAt(r--, tmp);
            }
            l=next;
            r=next;
        }
        return sb.toString();
    }

    private static char[] reverse(char[] arr, int l, int r){
        while(l<r){
            char tmp =arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
        return arr;
    }
    public static void reverseWords(char[] s){
//    public static String reverseWord2(String s){
        // reverse the whole string
        char[] tmp = reverse(s,0,s.length-1);
        int n = s.length;
        //rever each word
        int start =0;
        int end=0;
        while(end<n){
            while( end < n && s[end] !=' ' ) end++;
            System.out.println("end="+end);
            end--;
            System.out.println("end="+end);
            reverse(s, start, end);
            end+=2;
            start = end;
            System.out.println("end="+end);
        }
        System.out.println(s);
    }

    //the sky is blue
    public static void main(String[] args){
        reverseString ins = new reverseString();
//        System.out.println(ins.reverseWord("the sky is blue" ));
        String str = new String("the sky is blue");

        ins.reverseWords(str.toCharArray());


    }
}
