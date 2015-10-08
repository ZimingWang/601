package tree;

/**
 * Created by lipingxiong on 9/6/15.
 */
public class addSearchWord {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        // Initialize your data structure here.
        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root ;
    public addSearchWord(){
        root = new TrieNode();
    }
    public void addWord(String word){
        TrieNode cur= root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEndOfWord = true;
    }
    public boolean search(String word){
//        return match(word.toCharArray(), 0, root);
        return false;
    }

}
