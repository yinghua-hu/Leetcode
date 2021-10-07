class Solution {
    int m;
    int n;
    int[] dir = new int[] {-1, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        char[] s = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, s, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;        
    }
    
    public boolean dfs(char[][] board, char[] s, int i, int j, int k) {
        if (!inArea(i, j) || s[k] != board[i][j]) {
            return false;
        }
        if (k == s.length - 1) {
            return true;
        }
        board[i][j] = '#';
        boolean ret = false;
        for (int d = 0; d < 4; d++) {
            if (dfs(board, s, i + dir[d], j + dir[d + 1], k + 1)) {
                ret = true;
                break;
            }
        }        
        board[i][j] = s[k];
        return ret;
    }
    
    public boolean inArea (int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

/*
DFS
Time - O(N * 3 ^ len), len is the length of word, N is the number of elements in board
Space - O(len)

How to gurranttee "The same letter cell may not be used more than once."

1. visited boolean 2d array, need space

2. modify board[i][j] to character not in the search range, such as '#', we need to modify it back after search, backtracking, no need for extra space

*/
