class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length(), maxLen = n/k, maxFreq = 0;
        int[] sNums = new int[n];
        for(int i = 0; i < n; i++) sNums[i] = s.charAt(i)-'a';

        int[] cnt = new int[26];
        for(int i = 0; i < n; i++) maxFreq = Math.max(maxFreq, ++cnt[sNums[i]]);
        if(maxFreq < k) return "";
        int validLettersCnt = 0;
        for(int f : cnt) if(f >= k) validLettersCnt++;
        int[] validLetters = new int[validLettersCnt];
        int validLetterIndex = 0;

        for(int i = 25; i >= 0; i--) if(cnt[i] >= k) validLetters[validLetterIndex++] = i;
        List<Long>[] seq = new ArrayList[maxLen + 1];
        for(int i = 1; i <= maxLen; i++) seq[i] = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            long seqLong = i+1;
            for(int mult = 1; cnt[i] >= k*mult; mult++) {
                seq[mult].add(seqLong);
                seqLong = ((seqLong << 5) | (i+1));
            }
        }
        int len = 2;
        while(len <= maxLen) {
            for(long prevSeq : seq[len-1]) {
                int[] seqCnts = new int[26];
                long prevItr = prevSeq;
                while(prevItr > 0) {
                    seqCnts[(int)(prevItr & 31) - 1]+=k;
                    prevItr >>= 5;
                }
                for(int validLetter : validLetters) {
                    if(cnt[validLetter] == seqCnts[validLetter]) continue;
                    long newSeq = prevSeq | ((validLetter+1L) << (5*(len-1)));
                    if(hasKRepeats(sNums, newSeq, k)) seq[len].add(newSeq);   
                }
            }
            if(seq[len].isEmpty()) break;
            len++;
        }
        long maxLongSeq = 0;
        for(long seqLong : seq[len-1]) maxLongSeq = Math.max(seqLong, maxLongSeq);
        return longToString(maxLongSeq);
    }

    private String longToString(long num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            sb.append((char)('a' + (num & 31) - 1));
            num >>= 5;
        }
        return sb.reverse().toString();
    }
    private boolean hasKRepeats(int[] sNums, long subseq, int k) {
        long currSubseq = subseq;
        int repeats = 0;
        for(int i = sNums.length-1; i >= 0 && repeats < k; i--) {
            if(sNums[i] != (currSubseq & 31)-1) continue;
            currSubseq >>= 5;
            if(currSubseq == 0) {
                currSubseq = subseq;
                repeats++;
            }
        }
        return repeats == k;
    }
}