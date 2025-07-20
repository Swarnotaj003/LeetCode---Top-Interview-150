package trie;

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        } 
        return curr != null && curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        } 
        return curr != null;
    }
}

public class ImplementTrie {
    /*
        LeetCode (98/150)
        https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity* : O(m)
        Auxiliary Space**: O(m*n)

        * for each of the methods insert(), search() & startsWith()
        **n = no. of words inserted, m = avg. length of word

        Example 1:
        Input
        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        Output
        [null, null, true, false, true, null, true]
        Explanation
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
    */

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("appetite");
        trie.insert("apple");
        System.out.println(trie.search("appetite"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        
        trie.insert("application");
        System.out.println(trie.startsWith("api"));
        trie.insert("apicall");
        System.out.println(trie.startsWith("api"));
    }
}
