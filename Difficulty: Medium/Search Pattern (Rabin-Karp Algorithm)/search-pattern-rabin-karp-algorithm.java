class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int d = 256, q = 101;
        int m = pat.length(), n = txt.length();
        int p = 0, t = 0, h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j = 0;
                while (j < m && txt.charAt(i + j) == pat.charAt(j)) j++;
                if (j == m) result.add(i + 1);
            }
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }

        return result;
    }
}