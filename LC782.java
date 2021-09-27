class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[0][j]) != (board[i][0] ^ board[i][j])) {
                    return -1;
                }
                if ((board[0][0] ^ board[i][0]) != (board[0][j] ^ board[i][j])) {
                    return -1;
                }
            }
        }
        
        int colSum = 0; //count of 1s in the column
        int colXorSum = 0;
        for (int i = 0; i < n; i++) {
            colSum += board[i][0];
            colXorSum += (i % 2) ^ board[i][0];
        }
        if (Math.abs(colSum - (n - colSum)) > 1) {
            return -1;
        }
        
        int rowSum = 0;
        int rowXorSum = 0;
        for (int j = 0; j < n; j++) {
            rowSum += board[0][j];
            rowXorSum += (j % 2) ^ board[0][j];
        }        
        if (Math.abs(rowSum - (n - rowSum)) > 1) {
            return -1;
        }
        
        int ans = 0;
        if (n % 2 == 1) { // odd
            if (colSum > (n - colSum)) { // we have more 1s than 0s, 1 0 1
                ans += (n - colXorSum) / 2;
            }
            else { // 0 1 0
                ans += colXorSum / 2;
            }
            if (rowSum > (n - rowSum)) { // we have more 1s than 0s, 1 0 1
                ans += (n - rowXorSum) / 2;
            }
            else { // 0 1 0
                ans += rowXorSum / 2;
            }
        }
        else { // even
            ans = (Math.min(rowXorSum, n - rowXorSum) + Math.min(colXorSum, n - colXorSum)) / 2;
        }
        return ans;
    }
}

/*
valid chessboards

n is even
1 0 1 0
0 1 0 1
1 0 1 0
0 1 0 1

n is odd
1 0 1
0 1 0
1 0 1

1. Two patterns in column or row

Exclusive or : ^, return 1 when two binary element is different, return 0 when they are same
1 ^ 1 = 0;
1 ^ 0 = 1;
0 ^ 1 = 1;
0 ^ 0 = 0;

if ((board[0][0] ^ board[0][j]) != (board[i][0] ^ board[i][j])) {
    return -1;
}

2. count of 1s and count of 0s in each column / row can only differ by 1 or 0



Number of swaps to make the board a chessboard

1. n is even, look at first row and first column

for the row, there is only two patterns

0 1 0 1
1 0 1 0

we just need to calculate the difference between current row and these patterns, and select the pattern with smaller difference

2. n is odd, there can only be one pattern

1 0 1

we need to calculate the difference between current row and pattern


We do the same for column and we need to divide by two to get the number of swaps

time : O(N) N is the elements in the board

*/
