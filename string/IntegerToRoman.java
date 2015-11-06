package string;

import java.util.ArrayList;

/**
 */
public class IntegerToRoman {
    //I 1
    //V 5
    //X 10
    //L 50
    //C 100
    //D 500
    //M 1,000
    /*
    public String intToRoman(int num) {
        // ArrayList<Integer> digits = new ArrayList<Integer>();
        int[] digits = new int[4];
        int div = 1000;
        int i=0;
        while(num>0){
            digits[i++] = (num / div);
            num  = num % div ;
            div /= 10;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(convert(digits[0], 'M', ' ', ' '));
        sb.append(convert( digits[1], 'C', 'D', 'M'));
        sb.append(convert( digits[2],'X','L','C') );
        sb.append(convert( digits[3],'I','V','X') );
        return sb.toString();
    }

    public String convert(int digit, char one,char five,char ten){
        StringBuilder sb = new StringBuilder();
        switch(digit){
            case 9:
                sb.append(one);
                sb.append(ten);
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                sb.append(five);
                for(int i=digit;i>5;i--){
                    sb.append(one);
                }
                break;
            case 4:
                sb.append(one);
                sb.append(five);
                break;
            case 3:
            case 2:
            case 1:
                for(int i=digit;i>=1;i--) sb.append(one);
                break;
            default:break;
        }
        return sb.toString();
    }
*/
    public static void main(String[] args) {
        intToRoman(10);
    }
    public static String intToRoman(int num) {
        //I 1
        //V 5
        //X 10
        //L 50
        //C 100
        //D 500
        //M 1,000
        if(num<1 || num>3999)
            return "";
        int digit = 1000;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(digit>0)
        {
            digits.add(num/digit);
            num %= digit;
            digit /= 10;
        }
        System.out.println(digits.size());
        StringBuilder res = new StringBuilder();
        res.append(convert(digits.get(0),'M',' ', ' '));
        res.append(convert(digits.get(1),'C','D', 'M'));
        res.append(convert(digits.get(2),'X','L', 'C'));
        res.append(convert(digits.get(3),'I','V', 'X'));
        return res.toString();
    }
    public static String convert(int digit, char one, char five, char ten)
    {
        StringBuilder res = new StringBuilder();
        switch(digit)
        {
            case 9:
                res.append(one);
                res.append(ten);
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                res.append(five);
                for(int i=5;i<digit;i++)
                    res.append(one);
                break;
            case 4:
                res.append(one);
                res.append(five);
                break;
            case 3:
            case 2:
            case 1:
                for(int i=0;i<digit;i++)
                    res.append(one);
                break;
            default:
                break;


        }
        return res.toString();
    }
// 题目思路很简单，主要就是考察一下对于整数和字符串的操作，属于比较基本的题目。

    public int romanToInt(String s) {
        //I 1
        //V 5
        //X 10
        //L 50
        //C 100
        //D 500
        //M 1,000
        int sum=0;
        if(s.indexOf("IV") != -1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[] = s.toCharArray();
        for(int i=0;i<s.length();i++){
            switch(c[i]){
                case 'M': sum+=1000;break;
                case 'D': sum+=500;break;
                case 'C': sum+=100;break;
                case 'L': sum+=50;break;
                case 'X': sum+=10;break;
                case 'V': sum+=5;break;
                case 'I': sum+=1;break;
            }
        }
        return sum;
    }


}

