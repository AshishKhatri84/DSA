//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private TrieNode root;
    private Map<Integer, Boolean> memo; // Memoization

    public boolean wordBreak(String s, String[] dictionary) {
        root = new TrieNode();
        memo = new HashMap<>();

        // Build Trie from dictionary
        for (String word : dictionary) {
            insert(word);
        }

        return dfs(s, 0);
    }

    // Insert words into Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    // DFS with Memoization
    private boolean dfs(String s, int start) {
        if (start == s.length()) return true; // Successfully segmented
        if (memo.containsKey(start)) return memo.get(start);

        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) break;

            node = node.children.get(c);
            if (node.isEndOfWord && dfs(s, i + 1)) {
                memo.put(start, true);
                return true;
            }
        }

        memo.put(start, false);
        return false;
    }
}
