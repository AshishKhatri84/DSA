class Solution {
    boolean sameFreq(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : charFreq.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return true;
        }

        if (freqCount.size() == 2) {
            List<Integer> freqs = new ArrayList<>(freqCount.keySet());
            int f1 = freqs.get(0), f2 = freqs.get(1);
            int c1 = freqCount.get(f1), c2 = freqCount.get(f2);

            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
                return true;
            }

            if ((f1 - f2 == 1 && c1 == 1) || (f2 - f1 == 1 && c2 == 1)) {
                return true;
            }
        }
        return false;
    }
}