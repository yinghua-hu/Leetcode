class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {        
        char[] s = answerKey.toCharArray();
        return Math.max(slideWindow(s, k, 'T'), slideWindow(s, k, 'F'));
    }
    public int slideWindow(char[] s, int k, char target) {
        int n = s.length;
        int i = 0;
        int j = 0;
        int count = 0; // count of the change
        int ans = 0;
        while (j < n) {
            if (s[j] == target) {
                count++;
            }
            if (count > k) {
                if (s[i] == target) {
                    count--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}

/*
1004. Max consecutive ones

1. change T to F, max consecutive Fs

2. change F to T, max consecutive Ts

Try 1 and 2, and get a max to return.

Slide window / Two pointers

Case 1.
i, j
counter

"TTFF"
 i j

O(N) 


*/
