class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list1.add(mat1[i][j]);
                list2.add(mat2[i][j]);
            }
        }
        Collections.sort(list2);
        int count = 0;
        int i = 0;
        int j = list2.size() - 1;

        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);
            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}