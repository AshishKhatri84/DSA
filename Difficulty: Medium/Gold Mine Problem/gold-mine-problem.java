class Solution {
    public int maxGold(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] gold = new int[rows][cols];

        // Initialize the last column of the gold matrix
        for (int i = 0; i < rows; i++) {
            gold[i][cols - 1] = mat[i][cols - 1];
        }

        // Fill the gold matrix from the second last column to the first column
        for (int j = cols - 2; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                // Collect gold from the current cell
                int right = gold[i][j + 1]; // right
                int rightUp = (i > 0) ? gold[i - 1][j + 1] : 0; // right up
                int rightDown = (i < rows - 1) ? gold[i + 1][j + 1] : 0; // right down

                gold[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            maxGold = Math.max(maxGold, gold[i][0]);
        }
        return maxGold;
    }
}