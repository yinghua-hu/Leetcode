public List<Integer> Eratosthenes(int n) {
        int[] q = new int[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (q[i] == 0) {
                int j = i * 2;
                while (j <= n) {
                    q[j] = 1;
                    j += i;
                }
            }            
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (q[i] == 0) {
                primes.add(i);
            }
        }
        return primes;
    }
