class Solution {
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }
    private int countAtMostK(String s, int k) {
        int n = s.length();
        int left = 0, right = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}