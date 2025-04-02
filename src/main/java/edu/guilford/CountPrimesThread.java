package edu.guilford;

/**
 * This class extends Thread and will be used to count prime numbers in a given
 * range.
 */

public class CountPrimesThread extends Thread {
    private int id; // The ID of the thread
    private int start;
    private int end;
    private int interval;

    // Constructor to initialize the thread with an ID, start, end, and interval
    public CountPrimesThread(int id, int start, int end, int interval) {
        this.id = id; // Thread ID
        this.start = start; // Start of the range
        this.end = end; // End of the range
        this.interval = interval; // Interval for counting primes
    }

    @Override
    public void run() {
        // Every Thread object should have a run() method that specifies what it should
        // do
        long startTime = System.nanoTime();
        int count = PrimeUtilities.countPrimes(start, end, interval); // Count primes in the range
        long endTime = System.nanoTime();
        System.out.println("Thread " + id + " counted " + count +
                " primes from " + start + " to " + end +
                " with interval " + interval + ". Time taken: " +
                (endTime - startTime) / 1.e9 + " s");
    }
}
