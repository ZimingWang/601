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
        TrieNode root;//root of whole tree

        public Trie(){
            root= new TrieNode();
        }
        public void insert(String word){
            TrieNode runner = root;
            for(char c:word.toCharArray()){
                if(runner.children[c-'a'] == null){
                    runner.children[c-'a'] = new TrieNode();
                    runner = runner.children[c-'a'];
                }
            }
            runner.isEndOfWord = true;
        }
        public boolean search(String word){
            TrieNode runner = root;
            for(char c: word.toCharArray()){
                if(runner.children[c-'a'] == null){
                    return false;
                }
                else{
                    runner= runner.children[c-'a'];
                }
            }
            return runner.isEndOfWord;
        }
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix){
            TrieNode runner = root;
            for(char c: prefix.toCharArray()){
                if(runner.children[c-'a'] == null){
                    return false;
                }
                else{
                    runner= runner.children[c-'a'];
                }
            }
            return true;
        }
    }
}
