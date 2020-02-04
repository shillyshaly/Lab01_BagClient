import java.util.Random;

/**
 * An abstract class that implements a Money object.
 *
 * @author Jamie Hernandez
 * @version 1/28/2020
 */

public abstract class Money {
    private boolean heads;

    public Money() {
        // TODO Project2 - DONE
        this.heads = false;
    }

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

    public boolean isHeads() {
        // TODO Project2 - DONE
        return this.heads; // THIS IS A STUB
    }

    public abstract double getValue();

    public abstract String toString();
}
