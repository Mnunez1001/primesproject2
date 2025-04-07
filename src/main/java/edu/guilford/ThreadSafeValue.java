package edu.guilford;

public class ThreadSafeValue {
    private int value = 0;

    // We're protecting value against simultaneous access and update
    // by multiple threads
    public synchronized int getValue() {
        // When a thread enters this method, it puts a **lock** on the object
        // and releases that lock when the method exits
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public synchronized int getAndIncrement() {
        // The lock only applies to the code in this method
        int currentValue = value;
        value++;
        return currentValue;
    }
}
