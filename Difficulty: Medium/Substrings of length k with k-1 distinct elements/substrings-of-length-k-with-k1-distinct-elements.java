class Solution {
    public int substrCount(String s, int k) {
        int n = s.length();
        if (k > n) return 0; 
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (charCount.size() == k - 1) {
            count++;
        }

        for (int i = k; i < n; i++) {
            char outgoing = s.charAt(i - k);
            charCount.put(outgoing, charCount.get(outgoing) - 1);
            if (charCount.get(outgoing) == 0) {
                charCount.remove(outgoing);
            }

            char incoming = s.charAt(i);
            charCount.put(incoming, charCount.getOrDefault(incoming, 0) + 1);

            if (charCount.size() == k - 1) {
                count++;
            }
        }
        return count;
    }
}