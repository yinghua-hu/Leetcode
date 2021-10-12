/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long lo = 1;
        long hi = (long) Integer.MAX_VALUE + 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            int res = guess((int) mid);
            if (res == 0) {
                return (int) mid;
            }
            if (res == -1) { // guess mid is too high
                hi = mid;
            }
            else { // mid is too low
                lo = mid + 1;
            }
        }
        return (int) (lo - 1);
    }
}


/*
Binary Search
false false true true 
log(N) N - search space
[lo, hi)

long lo = 1;
long hi = Integer.MAX_VALUE + 1

while (lo < hi) {
    long mid = lo + (hi - lo) / 2;
    int res = guess((int) mid);
    if (res == 0) {
        return mid;
    }
    if () { // mid is too high
        hi = mid;
    }
    else { // mid is too low
        lo = mid + 1;
    }
}
lo == hi


*/
