import java.util.Random;

/**
 * An abstract class that implements a Money object.
 *
 * @author Jamie Hernandez
 * @version 1/28/2020
 */

public abstract class Money {
    private boolean heads;

    /**
     * constructor for Money object
     * sets heads to false
     */
    public Money() {
        // TODO Project2 - DONE
        this.heads = false;
    }

    /**
     * simulates coin toss to randomly decide which side coin/bill lands on
     */
    public void toss() {
        // TODO Project2 - DONE
        Random random = new Random();
        int flip = random.nextInt(2);
        if (flip != 0) {
            this.heads = false;
        }
        else {
            this.heads = true;
        }
    }

    /**
     *
     * @return if the object landed heads or tails
     */
    public boolean isHeads() {
        // TODO Project2 - DONE
        return this.heads;
    }

    public abstract double getValue();

    public abstract String toString();
}
