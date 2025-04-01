class Solution {
    public long mostPoints(int[][] ques) {
        int n = ques.length;
        Long[] arr = new Long[n];
        return check(ques, 0, arr);
    }
    private long check(int[][] ques, int i, Long[] arr) {
        if(i >= ques.length) return 0;
        if(arr[i] != null) return arr[i];
        return arr[i] = Math.max(check(ques, i + 1, arr), ques[i][0] + check(ques, i + ques[i][1] + 1, arr));
    }
}