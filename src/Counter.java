/**
 * @author Gitali Naim
 */

public class Counter {
    private int value;

    /**
     * constructor of counter.
     *
     * @param value - the value of the counter
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * add number to current count.
     *
     * @param number - the number that will add to the current count
     */
    void increase(int number) {
        this.value += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number - the number that will subtract from the current count
     */
    void decrease(int number) {
        this.value -= number;
    }

    /**
     * get current count.
     *
     * @return the current count
     */
    int getValue() {
        return this.value;
    }
}
