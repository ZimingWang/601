package string;

/**
 */
public class zigZagConversion {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int n=c.length;
        StringBuilder sb[]=new StringBuilder[nRows];
        int i=0;
//        int sbIndex=0;
        while(i<c.length){
            for(int sbIndex=0;sbIndex<nRows && i<n;sbIndex++ ){
                sb[sbIndex].append(c[i++]);
            }
            for(int sbIndex=nRows-2;sbIndex>=1 && i<n;sbIndex--){
                sb[sbIndex].append(c[i++]);
            }
        }
        for(int j=1;j<nRows;j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
