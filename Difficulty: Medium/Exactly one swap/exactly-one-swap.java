class Solution {
    public int countStrings(String s) {
        int n = s.length();
        long totalSwaps = (long) n * (n - 1) / 2;

        int[] freq = new int[26];
        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
            if (freq[idx] > 1) hasDuplicate = true;
        }

        long sameCharSwaps = 0;
        for (int f : freq) {
            sameCharSwaps += (long) f * (f - 1) / 2;
        }

        long distinct = totalSwaps - sameCharSwaps;

        // If any duplicate character exists, original string could be formed by multiple swaps
        if (hasDuplicate) {
            return (int)(distinct + 1);
        } else {
            return (int)(distinct);
        }
    }
}
