package tree;

/**
 * Created by lipingxiong on 9/6/15.
 */
public class tire {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        // Initialize your data structure here.
        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
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
            TrieNode cur = root;
            for(char c:word.toCharArray()){
                if(cur.children[c-'a']==null) return false;
                cur = cur.children[c-'a'];
            }
            return cur.isEndOfWord;
        }

    }
}
