class Solution {
    private char[] s;
    private int k;
    private int[] count = new int[26];
    private String max = "";

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s.toCharArray();
        this.k = k;
        for (char c : this.s) count[c - 'a']++;
        fn(new char[8], 0);
        return max;
    }
    private void fn(char[] curr, int sz) {
        for (int c = 25; c >= 0; c--) {
            if (count[c] >= k) {
                //curr.append((char) ('a' + c));
                curr[sz++] = (char) ('a' + c);
                if (isSubsequence(curr, sz)) {
                    if (sz > max.length()) {
                        max = new String(curr, 0, sz);
                    }
                    count[c] -= k;
                    fn(curr, sz);
                    count[c] += k;
                }
                sz--;
            }
        }
    }
    private boolean isSubsequence(char[] t, int sz) {
        if (sz == 1) return true;
        int pos = 0, cnt = 0;
        for (char c : s) {
            if (c == t[pos]) {
                pos++;
                if (pos == sz) {
                    cnt++;
                    if (cnt == k) return true;
                    pos = 0;
                }
            }
        }
        return false;
    }
}