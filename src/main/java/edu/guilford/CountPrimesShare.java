package edu.guilford;

public class CountPrimesShare extends Thread {
    private int id;
    // public static int currentValue; // Keeping track of the number that
    public static ThreadSafeValue currentValue = new ThreadSafeValue(); // Keeping track of the number that
    // will be next to be checked
    public static int end;

    public CountPrimesShare(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        int count = 0;
        long startTime = System.nanoTime();
        int value = currentValue.getValue();
        while (value <= end) {

            // System.out.println("Thread " + id + " is checking " + currentValue);
            // Each object gets the value of currentValue right at this moment

            // Lock all access to currentValue until this code block is complete
            synchronized (currentValue) {
                value = currentValue.getAndIncrement(); // Get the current value and increment it
            }

            if (PrimeUtilities.isPrime(value)) {
                count++;
            }
            // currentValue++;

        }
        long endTime = System.nanoTime();
        System.out.println("Thread " + id + " counted " + count +
                ". Time taken: " +
                (endTime - startTime) / 1.e9 + " s");
    }

}
