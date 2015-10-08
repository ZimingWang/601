package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class findStrobogrammatic {

    public static void main(String[] args){
//        System.out.println(findStrobogrammatic(1));
//        System.out.println(findStrobogrammatic(2));
//        System.out.println(findStrobogrammatic(3));
//        System.out.println(findStrobogrammatic(4));
//        System.out.println(findStrobogrammatic(5));
//        System.out.println(findStrobogrammatic(6));

        System.out.println(findStrobogrammatic(1).size()); //size1=3
        System.out.println(findStrobogrammatic(2).size()); //size2=4
        System.out.println(findStrobogrammatic(3).size()); //size3=3*size2= 3* 4 = 12
        System.out.println(findStrobogrammatic(4).size()); //size4=5*size2= 5 *4 = 20
        System.out.println(findStrobogrammatic(5).size()); //size5=3*size4= 3* 20 = 60
        System.out.println(findStrobogrammatic(6).size()); //size6=5*size4 = 5*20 = 100

//        String s="6889";
//        int m =(s.length()+1)/2;
//        System.out.println(s.substring(0,m));
//        System.out.println(s.substring(m,s.length()));
    }
/*
/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/bin/java -Didea.launcher.port=7546 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14 CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/javafx-doclet.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/lib/tools.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/htmlconverter.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Users/lipingxiong/opt/leetcode/out/production/leetcode:/Applications/IntelliJ IDEA 14 CE.app/Contents/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain others.findStrobogrammatic
[0, 1, 8]
[11, 69, 88, 96]
[101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, 986]
[1001, 1111, 1691, 1881, 1961, 6009, 6119, 6699, 6889, 6969, 8008, 8118, 8698, 8888, 8968, 9006, 9116, 9696, 9886, 9966]
[10001, 10101, 10801, 11011, 11111, 11811, 16091, 16191, 16891, 18081, 18181, 18881, 19061, 19161, 19861, 60009, 60109, 60809, 61019, 61119, 61819, 66099, 66199, 66899, 68089, 68189, 68889, 69069, 69169, 69869, 80008, 80108, 80808, 81018, 81118, 81818, 86098, 86198, 86898, 88088, 88188, 88888, 89068, 89168, 89868, 90006, 90106, 90806, 91016, 91116, 91816, 96096, 96196, 96896, 98086, 98186, 98886, 99066, 99166, 99866]
[100001, 101101, 106901, 108801, 109601, 110011, 111111, 116911, 118811, 119611, 160091, 161191, 166991, 168891, 169691, 180081, 181181, 186981, 188881, 189681, 190061, 191161, 196961, 198861, 199661, 600009, 601109, 606909, 608809, 609609, 610019, 611119, 616919, 618819, 619619, 660099, 661199, 666999, 668899, 669699, 680089, 681189, 686989, 688889, 689689, 690069, 691169, 696969, 698869, 699669, 800008, 801108, 806908, 808808, 809608, 810018, 811118, 816918, 818818, 819618, 860098, 861198, 866998, 868898, 869698, 880088, 881188, 886988, 888888, 889688, 890068, 891168, 896968, 898868, 899668, 900006, 901106, 906906, 908806, 909606, 910016, 911116, 916916, 918816, 919616, 960096, 961196, 966996, 968896, 969696, 980086, 981186, 986986, 988886, 989686, 990066, 991166, 996966, 998866, 999666]

Process finished with exit code 0

 */

    public static List<String> findStrobogrammatic(int n){
        //Given n = 2, return ["11","69","88","96"]
        //n=1, [0,1,8]
        List<String> l1 = new ArrayList<>();
        l1.add("0");
        l1.add("1");
        l1.add("8");
        if(n==1){
            return l1;
        }
        List<String> l2=new ArrayList<>();
        l2.clear();
        l2.add("00");
        l2.add("11");
        l2.add("69");
        l2.add("88");
        l2.add("96");
        List<String> l3= new ArrayList<>(l2);
        l3.remove(0);
        if(n==2){
            return l3;
        }
        /*
        n=2 ["11","69","88","96"]
n=3 101,,111,181,609,619,689,8*8, 9*6   n%2==1, insert n1=1's elements
n=4 1001,1111,1881,6**9      //n%2==0, insert n=2's elements
6699,6969,6119

n=5 10*01,

n=6 10**01,
n=8 100**001
    0123
         */
        // n>=3
        List<String> preRes;
        char[] sArr;
        int insertIndex=0;
        List<String> newRes=new ArrayList<>();
        if(n%2==1){
            preRes=findStrobogrammatic(n-1);
            insertIndex=n/2;
            for(String s:preRes) {
                for (String e:l1) {
                    newRes.add(s.substring(0,insertIndex) + e + s.substring(insertIndex, s.length()));
                }
            }
        }
        else{
            preRes = findStrobogrammatic(n-2);
            insertIndex=n/2-1; //n==4,insertIndex=1. n==6,insertIndex=2,n==8,insertIndex=3
            for(String s:preRes){
                for(String e:l2){
                    newRes.add(s.substring(0,insertIndex) + e+ s.substring(insertIndex,s.length()) );
                }
            }
        }
        return newRes;
    }
}
