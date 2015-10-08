package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Repeated DNA Sequences

 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 *超内存的原因是什么？肯定是map中的第一个字段，它是字符串，肯定需要很多空间。能不能换个思维，把字符串哈希一下，
 * 哈希成可以用比较小的空间就能表示的？因为可能出现的字符只有四种：AGCT，那么这么设计哈希函数：A->0,C->1,G->2,T->3。
 * 如此一来，把长度为10的字符串映射（哈希）成整数。

 */
public class repeatDNASequence {
    public static void main(String args[]){
//        System.out.println(change("AAAAACCCCC"));
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
    public static int getNum(String s){
        int res = 0;
        for(int i=0;i<s.length();i++){
            res*=10;
            switch(s.charAt(i)){
                case 'A':{res+=1;break;}
                case 'C':{res+=2;break;}
                case 'G':{res+=3;break;}
                case 'T':{res+=4;break;}
            }
        }
        return res;
    }
//"AGCT"
//    0,1
//    10+2- 12
    public static List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res=new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        //定义个hashmap,key为字符串，value为该字符串出现的次数
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        //对所有长度为10的字串进行遍历
        for(int i=0;i<=s.length()-10;i++)
        {
            String cur=s.substring(i,i+10);
            if(!map.containsKey(cur))
            {
                map.put(cur,1);
            }else{
                map.put(cur,map.get(cur)+1);
            }
        }

        /*
        //选出那些出现次数大于1次的那些字符串
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String key=(String)iterator.next();
            int val=map.get(key);
            if(val>1)
                res.add(key);
        }*/
        return res;

    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        ArrayList<String> res=new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        //定义个hashmap,key为字符串转变成的整数，value为该字符串出现的次数
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        //对所有长度为10的字串进行遍历
        for(int i=0;i<=s.length()-10;i++)
        {
            String cur=s.substring(i,i+10);
            int curint=change(cur);
            if(!map.containsKey(curint))
            {
                map.put(curint,1);
            }else{
                if(map.get(curint)==1)
                    res.add(cur);
                map.put(curint,map.get(curint)+1);
            }
        }
        return res;
    }

    private static int change(String s){
        int res=0;
        for(int i=0;i<s.length();i++)
        {
            res*=10;
            switch(s.charAt(i)){
                case 'A':{res+=1;break;}
                case 'C':{res+=2;break;}
                case 'G':{res+=3;break;}
                case 'T':{res+=4;break;}
            }
        }
        return res;
    }

}
