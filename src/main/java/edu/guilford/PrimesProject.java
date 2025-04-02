package edu.guilford;

public class PrimesProject {
    public static final int MIN = 20000000;
    public static final int MAX = 40000000;
    public static void main(String[] args) {
        int numberOfThreads = 4;
        // Make an array of CountPrimesThread objects
        CountPrimesThread[] threads = new CountPrimesThread[numberOfThreads];
        int interval = (MAX - MIN) / numberOfThreads; // Calculate the interval for each thread
        // Instantiate each thread
        for (int i = 0; i < numberOfThreads; i++){
            threads[i] = new CountPrimesThread(i, MIN + interval * i, 
                MIN + interval * (i + 1) - 1, 1); // Create a new thread with the start and end values
        }
        // Start each thread
        for (int i = 0; i < numberOfThreads; i++) {

            // start both spawns a separate thread and then sends the run message to it
            threads[i].start(); // We use the start method and not the run method to start 
            // a thread as a separate task
            // When we use run, we're not spawning a new thread
            // The run method would then just run in the main thread
            // and we're not using multiprocessing
            //threads[i].run();
        }
    }
}