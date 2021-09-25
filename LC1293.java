class Solution {
    int m;
    int n;
    int[] dir = new int[]{-1, 0, 1, 0, -1};
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int[] cur = que.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int r1 = cur[0] + dir[i];
                    int c1 = cur[1] + dir[i + 1];
                    if (!inArea(r1, c1)) {
                        continue;
                    }
                    int k1 = cur[2];
                    if (grid[r1][c1] == 1) {
                        k1--;
                    }
                    if (k1 < 0 || visited[r1][c1][k1]) {
                        continue;
                    }
                    visited[r1][c1][k1] = true;
                    que.add(new int[] {r1, c1, k1});
                }
                size--;
            }            
            steps++;
        }
        return -1;
    }
    
    public boolean inArea(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
