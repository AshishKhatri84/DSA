import java.util.Arrays;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean allPrefixesExist(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null || !node.isEndOfWord) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String longestString(String[] words) {
        // Sort the words lexicographically
        Arrays.sort(words);
        
        // Create a Trie and insert all words
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        String longestWord = "";
        
        // Check each word for prefix existence
        for (String word : words) {
            if (trie.allPrefixesExist(word)) {
                if (word.length() > longestWord.length() || 
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        
        return longestWord;
    }
}
