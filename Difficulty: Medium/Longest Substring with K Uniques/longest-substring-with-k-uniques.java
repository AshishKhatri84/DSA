class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = -1;

        for (int right = 0; right < s.length(); right++) {
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);

            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) {
                    charCount.remove(s.charAt(left));
                }
                left++;
            }
            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}