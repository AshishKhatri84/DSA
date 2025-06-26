class Solution {
    public int minValue(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        while (k > 0 && !pq.isEmpty()) {
            int top = pq.poll();  
            top--;               
            k--;
            if (top > 0) pq.add(top);  
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int f = pq.poll();
            result += f * f;
        }

        return result;
    }
}