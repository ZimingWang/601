package facebook;

/**
 * Created by lipingxiong on 10/18/15.
 */

public class facebooks {
//    bool strstrp(string a, string b) {
//        if (b == "") return true;
//        unordered_map<char, int> m1;
//        unordered_map<char, int> m2;
//        for(int i = 0; i < b.size(); i++) m1[b]++;. 1point3acres.com/bbs
//        for(int i = 0; i <= a.size() - b.size(); i++) {
//            m2 = m1;
//            for(int j = 0; j < b.size(); j++) {. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
//                if(m2.find(a[i + j]) != m2.end()) {. Waral 鍗氬鏈夋洿澶氭枃绔�,
//                    m2[a[i + j]]--;
//                    if(m2[a[i + j]] == 0) m2.erase(a[i + j]);
//                } else {
//                    break;
//                }. more info on 1point3acres.com
//            } .1point3acres缃�
//            if(m2.empty()) return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
////        solveN(11,new int[]{1,2,3,4,5});
//        isPld();
//    }
    public  static int minSubArrayLen(int s, int[] nums) {
        return solveN(s, nums);
    }

    private static int solveN(int s, int[] nums) {
        int start = 0,i=0, j = 0,  minLen = Integer.MAX_VALUE;
        int sum=0;
        int n = nums.length;

        while(i<n) {
            System.out.println("i="+i);
            while(i<n && sum<s) {
                System.out.println(i);
                sum+=nums[i++];
            }
            if(sum<s) return 0;
            while(j<i&&sum>=s){

                sum-=nums[j++];

                if(j<i&&sum==s) minLen = Math.min(minLen,i-j);
                System.out.println(j + " "+i + " sum="+sum+"minLne="+minLen);
            }
//            if(sum==s) minLen = Math.min(minLen,i-j);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void  main(String[] args){
        System.out.println(isPld("a"));
        System.out.println(isPld(","));
        System.out.println(isPld(",,"));
        System.out.println(isPld(",b,"));
        System.out.println(isPld("a,,a"));
        System.out.println(isPld("a,b,a"));
        System.out.println(isPld(",,a"));
    }
    public static boolean isPld(String s){
        if(s==null || s.length()==0)return false;
        int i=0,j=s.length()-1;
        int n = s.length();
        while(i<=j){
            while(i<n && !isValid(s.charAt(i)))i++;
            if(i==n) return false;
            while(!isValid(s.charAt(j)))j--;
            if(!isSame(s.charAt(i),s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isValid(char c){
        if(c<='Z'&& c>='A'||c<='z'&&c>='a'){
            return true;
        }
        return false;
    }
    public static boolean isSame(char c1,char c2){
//        if()
        if(c1<='Z'&&c1>='A') c1 = (char) (c1-'A'+'a');
        if(c2<='Z'&&c2>='A') c2 = (char) (c2-'A'+'a');
        return c1==c2;
    }
/*
""
","
",,"
",a"
"a"

"a,,a"
"a,b,a"

 */
}

