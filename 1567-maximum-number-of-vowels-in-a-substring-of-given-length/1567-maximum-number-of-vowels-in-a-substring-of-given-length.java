class Solution {
    public int maxVowels(String s, int k) {
        int count = 0, max = 0;
        for (int i = 0;i< s.length();i++){
            if (max == k){
                return max;
            }
            if (isVowels(s.charAt(i))){
                count++;
            }
            if (i >= k){
                if (isVowels(s.charAt(i-k))){
                    count--;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static boolean isVowels(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}