package trie;

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root) {
        // reached the end of word
        if (i == word.length()) {
            return root != null && root.isEndOfWord;
        }

        char ch = word.charAt(i);

        // wildcard character
        if (ch == '.') {
            // explore all children
            for (TrieNode child : root.children) {
                if (child != null && dfs(word, i+1, child)) {
                    return true;
                }
            }
            // no children found or suffix not present
            return false;
        }

        // no path found through the current character
        if (root.children[ch - 'a'] == null) {
            return false;
        }

        // move to the child through the current character
        return dfs(word, i+1, root.children[ch - 'a']);
    }
}

public class AddAndSearchWordsDataStructure {
    /*
        LeetCode (99/150)
        https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity* : O(m)
        Auxiliary Space**: O(m*n)

        * for each of the methods addWord() & search()
        * more specifically, search() takes O(26*26*m) time, as there will be at most 2 dots in word for search queries.
        **n = no. of words inserted, m = avg. length of word

        Example:
        Input
        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        Output
        [null,null,null,null,false,true,true,true]
        Explanation
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    */

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
