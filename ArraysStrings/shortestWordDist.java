package ArraysStrings;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class shortestWordDist {

    public static int shortestDistance(String[] words, String word1, String word2){
        int firstIdx=-1,seconddIdx=-1;
        int  min=words.length;
        for(int i=0;i<words.length;i++){
            if (words[i].equals(word1)) {
                firstIdx = i;
                System.out.println(firstIdx);
            }
            else if (words[i].equals(word2)){
                seconddIdx = i;
                System.out.println(seconddIdx);
            }
            if(firstIdx!=-1 && seconddIdx !=-1) {
                int cur = Math.abs(seconddIdx - firstIdx);
                System.out.println("cur=" + cur);
                if (cur < min) min = cur;
            }
        }
        return min;
    }

    public static void main(String[] args){
        String[] words={"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(words, "makes", "coding"));
        System.out.println(shortestDistance(words, "practice", "coding"));
    }

}
