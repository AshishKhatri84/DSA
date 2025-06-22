import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        ArrayList<Integer>[] dp = new ArrayList[n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(arr[i]);

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(arr[i]);
                } else if (arr[i] % arr[j] == 0 && dp[j].size() + 1 == dp[i].size()) {
                    // compare lex greatest after sorting
                    ArrayList<Integer> temp = new ArrayList<>(dp[j]);
                    temp.add(arr[i]);
                    if (isLexGreater(temp, dp[i])) {
                        dp[i] = temp;
                    }
                }
            }

            if (dp[i].size() > result.size() || 
               (dp[i].size() == result.size() && isLexGreater(dp[i], result))) {
                result = dp[i];
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean isLexGreater(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> sa = new ArrayList<>(a), sb = new ArrayList<>(b);
        Collections.sort(sa);
        Collections.sort(sb);
        for (int i = 0; i < Math.min(sa.size(), sb.size()); i++) {
            if (!sa.get(i).equals(sb.get(i)))
                return sa.get(i) > sb.get(i);
        }
        return sa.size() > sb.size();
    }
}