class Solution {
    int m;
    int n;
    int[] dir = new int[] {-1, 0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;   
                }
                else if (grid[i][j] == 2) {
                    que.add(new int[]{i, j});
                }                
            }
        }
        if (count == 0) {
            return 0;
        }
        int mins = 0;
        while (!que.isEmpty() && count > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int r1 = r + dir[k];
                    int c1 = c + dir[k + 1];
                    if (!inArea(r1, c1) || grid[r1][c1] != 1) {
                        continue;
                    }
                    count--;
                    grid[r1][c1] = 2;
                    que.add(new int[]{r1, c1});
                }
                
            }
            mins++;
        }
        return count == 0 ? mins : -1;
    }
    public boolean inArea(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}

/*
BFS
Time O(N)
Space O(N)
1. add all rotten cells to the queue
2. keep the count of the fresh orange
3. do BFS until there is no fresh orange or queue is empty
*/
