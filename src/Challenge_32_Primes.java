public class Challenge_32_Primes {
    public static void main(String[] args) {
        int limit = 100;
        int[] testPrimes = primesBelowLimit(limit);
        for(int i = 0; i< testPrimes.length; i++)
            System.out.print(testPrimes[i]+" ");
    }

    public static int[] primesBelowLimit(int limit) {
        int pos = 0, factors = 0;
        int count = 1;
        int[] primes = new int[limit];
        primes[pos] = 2;
        for (int num = 3; count < limit; num+=2) {
            factors = 0;
            for(int i = 3; i*i <= num; i++)
            {
                if (num%i == 0)
                    factors++;
            }
            if(factors == 0) {
                primes[++pos] = num;
                count++;
            }
        }

        return primes;

    }

}