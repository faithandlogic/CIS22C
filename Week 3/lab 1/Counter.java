
import java.lang.Object;

/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class Counter {
    // PUT PRIVATE DATA FIELDS HERE
    private int min;
    private int max;
    private int value;
    private boolean rolledOver;
    /**
     * The default constructor for objects of class Counter. Minimum is 0 and the
     * maximum
     * is the largest possible integer.
     */
    public Counter() {
        // ADD CODE FOR THE CONSTRUCTOR
        min = 0;
        max = Integer.MAX_VALUE;
        value = 0;
        rolledOver = false;
    }

    /**
     * The alternate constructor for objects of class Counter. The minimum and
     * maximum values are given as parameters.
     * The counter starts at the minimum value.
     * 
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     */
    public Counter(int min, int max) {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if (min > max) {
            throw new CounterInitializationException("Minimum value is greater than maximum value");
        } else if (min == max) {
            throw new CounterInitializationException("Minimum value is equal to maximum value");
        } else {
            this.min = min;
            this.max = max;
            value = min;
            rolledOver = false;
        }
    }

    /**
     * Determine if two counters are in the same state
     *
     * @param otherObject the object to test against for equality
     * @return true if the objects are in the same state
     */
    public boolean equals(Object otherObject) {
        boolean result = true;
        if (otherObject instanceof Counter) {
            // YOUR CODE GOES HERE
            Counter otherCounter = (Counter) otherObject;
            int otherMin = otherCounter.min;
            int otherMax = otherCounter.max;
            int otherValue = otherCounter.value;
            boolean otherRolledOver = otherCounter.rolledOver;

            if (min != otherMin || max != otherMax || value != otherValue || rolledOver != otherRolledOver) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Increases the counter by one
     */
    public void increase() {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (value + 1 > max) {
            value = min;
            rolledOver = true;
        } else {
            value++;
            rolledOver = false;
        }
    }

    /**
     * Decreases the counter by one
     */
    public void decrease() {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (value - 1 < min) {
            value = max;
            rolledOver = true;
        } else {
            value--;
            rolledOver = false;
        }
    }

    /**
     * Get the value of the counter
     *
     * @return the current value of the counter
     */
    public int value() {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return this.value;

    }

    /**
     * Accessor that allows the client to determine if the counter
     * rolled over on the last count
     *
     * @return true if the counter rolled over
     */
    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return this.rolledOver;
    }

    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return a descriptive string about the object
     */
    public String toString() {
        // CHANGE THE RETURN TO PROVIDE A DESCRIPTIVE STRING
        return "The counter is currently at " + value +
                " and has " + (rolledOver ? "" : "not ") + "rolled over." +
                " The minimum value is " + min + " and the maximum value is " + max + ".";
    }

}
