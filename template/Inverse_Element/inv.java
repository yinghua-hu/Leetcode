long inv(long x) 
    {
        long s = 1;
        for (; x > 1; x = mod % x)
          s = s*(mod - mod / x) % mod;
        return s;
    }
