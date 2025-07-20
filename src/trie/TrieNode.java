package trie;

/*
 * Implementation of a node in trie (prefix tree)
 * To be used in related DSA problems
 */

public class TrieNode {
    // indicate whether the current node traces out a word
    boolean isEndOfWord;

    // can have atmost 26 children, through 'a' to 'z'
    TrieNode[] children;

    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}
