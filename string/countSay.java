package string;

/**
 */
public class countSay {
    public static void main(String[] args){
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if(n==0) return "";
        StringBuilder sb = new StringBuilder("1");
        int count=1;

        for(int i=2;i<=n;i++){
            StringBuilder newsb= new StringBuilder();
            for(int j=1;j<sb.length();j++) {
                if (sb.charAt(j) == sb.charAt(j - 1)) {
                    count++;
                }
                else{
                    newsb.append(count);
                    newsb.append(sb.charAt(j-1));
                    count=1;
                }
            }
            newsb.append(count);
            newsb.append(sb.charAt(sb.length()-1));
            count=1;
            sb=newsb;
        }
        return sb.toString();
    }
}
