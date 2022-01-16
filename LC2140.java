class Solution {
    public int minMoves(int target, int k) {
        int count = 0;        
        while (target > 1 && k > 0) {
            if (target % 2 == 0) {
                target /= 2;
                k--;
            }
            else {
                target--;
            }
            count++;
        }
        count += target - 1;
        return count;
    }
}

// 1 -> target
// increment or double
// double can only be used k times
// 1. BFS, TLE  ~ 10^9 steps, LC only allow 10^6 - 10^7
// 2. Greedy
// 1 -> target
// target -> 1 by using half and decrement
// if target is not multiple of 2, we can only decrement
// else we need to choose between half or decrement

// it only allow k half / double operations
// 1 => double => 2  
// 2 + 1 = 3         increment
// increased 3 - 1 = 2 

// 1 + 1 = 2  increment
// 2 => double => 4
// increased 4 - 1 = 3

// we need to do double later if we don't have enough k => we do half firstly when go from target to 1
