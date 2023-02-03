/*Leetcode question 850 Rectangle Area II */
private class Diff2d {
    int m;
    int n;
    int[][] f;
    int[][] diff;
    public Diff2d(int m, int n) {
        this.m = m;
        this.n = n;
        f = new int[m][n];
        diff = new int[m][n];
    }
    public void set(int x0, int y0, int x1, int y1, int val) {
        diff[x0][y0] += val;
        diff[x1 + 1][y0] -= val;
        diff[x0][y1 + 1] -= val;
        diff[x1 + 1][y1 + 1] += val;
    }
    public void compute() {
        f[0][0] = diff[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = i == 0 ? 0 : f[i - 1][j];
                int b = j == 0 ? 0 : f[i][j - 1];
                int c = (i == 0 || j == 0) ? 0 : f[i - 1][j - 1];
                f[i][j] = a + b - c + diff[i][j];
            }
        }
    }
}
