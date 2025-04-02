package edu.guilford;

/**
 * Static methods that determine whether a method is prime and the number of prime numbers
 * between two values
 */
public class PrimeUtilities {
    /**
     * Counts the number of primes in a given range
     * @param min
     * @param max
     * @param interval
     * @return
     */
    public static int countPrimes(int min, int max, int interval) {
        int count = 0;
        for (int i = min; i <= max; i += interval) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int i) {
        int top = (int)Math.sqrt(i);
        // Handle special cases for 0 and 1
        if (i <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int j = 2; j <= top; j++) {
            if (i % j == 0) {
                return false; // i is divisible by j, so it's not prime
            }
        }
        return true; // If no divisors were found, i is prime
    }
}
