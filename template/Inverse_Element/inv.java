// more details see https://github.com/wisdompeak/LeetCode/tree/master/Template/Inverse_Element
long inv(long x)
    {
        long s = 1;
        for (; x > 1; x = mod % x)
          s = s*(mod - mod / x) % mod;
        return s;
    }
