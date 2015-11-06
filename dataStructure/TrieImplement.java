package dataStructure;

/**
 * Created by lipingxiong on 8/25/15.
 */
public class TrieImplement {

    class TrieNode{
        boolean isEndOfWord;
        TrieNode[] children;
        TrieNode(){
            isEndOfWord = false;
            children = new TrieNode[26];// max 26 children
        }
    }

    public class Trie{
        TrieNode root = null;

        public Trie(){
            root= new TrieNode();
        }
        public void insert(String word){

            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c-'a']==null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.isEndOfWord = true;

        }
        public boolean search(String word){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c-'a'] == null ) return false;
                else cur=cur.children[c-'a'];
            }
            return cur.isEndOfWord;

        }
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix){
            TrieNode cur = root;
            for(char c : prefix.toCharArray()){
                if(cur.children[c-'a'] == null){
                    return false;
                }
                else cur =cur.children[c-'a'];
            }
            return true;
        }
    }
}

//
//public class Trie{
//
//    public Trie(){
//
//    }
//    public void insert(String word){
//    }
//    public boolean search(String word){
//
//    }
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix){
//
//    }
//}
