
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * An abstract class that implements PiggyBank object.
 *
 * @author Jamie Hernandez
 * @version 02/02/2020
 */

public class PiggyBank {
    private ResizableArrayBag<Money> jar;
    private int capacity;

    /**
     * piggy bank constructor creates and fills piggy bank with random bill/coin objects while checking
     * if the piggy bank is full.
     * @param numberOfMonies - returns number of monies put into piggy bank
     * @param capacity - returns how many monies the piggy bank can hold
     */
    public PiggyBank(int numberOfMonies, int capacity) {
        this.jar = new ResizableArrayBag<>();
        this.capacity = capacity;

        System.out.println(">> Adding " + numberOfMonies + " monies to your piggy bank <<");

        if (numberOfMonies >= capacity) {
            numberOfMonies = capacity;
        }
        for (int i = 0; i < numberOfMonies; i++) {
            Money coin = new Coin();
            Money bill = new Bill();
            Random random = new Random();

            if (random.nextInt(2) == 0) {
                this.jar.add(coin);
                System.out.println("Added $" + String.format("%.2f", coin.getValue()) + " to the piggy bank");
            }
            else {
                this.jar.add(bill);
                System.out.println("Added $" + String.format("%.2f", bill.getValue()) + " to the piggy bank.");
            }
        }
        System.out.printf("\n");
    }

    /**
     * add money object to this.jar
     * @param money - money object to add
     */
    public void add(Money money) {
        try {
            if (this.jar.getCurrentSize() >= capacity) {
                throw new PiggyBankFullException("No more room in the piggy bank! - additional monies will not be added to your piggy bank");
            }
            else {
                this.jar.add(money);
                System.out.println("Added $" + String.format("%.2f", money.getValue()) + " to the piggy bank.");
            }
        } catch (PiggyBankFullException f) {
            f.printStackTrace();
        }
    }

    /**
     * remove random money object from this.jar
     * @return - shows object being removed
     */
    public Money remove() {
        try {
            if (this.jar.getCurrentSize() <= 0) {
                throw new PiggyBankEmptyException("Piggy bank is empty.");
            }
        } catch (PiggyBankEmptyException e) {
            e.printStackTrace();
        }
        return this.jar.remove();
    }

    /**
     *
     * @return - true if this.jar is empty
     */
    public boolean isEmpty() {
        return this.jar.isEmpty();
    }

    /**
     *
     * @return - true if this.jar is full
     */
    public boolean isFull() {
        boolean full = false;
        if (this.jar.getCurrentSize() >= capacity) {
            full = true;
        }
        return full;
    }

    /**
     *
     * @return - capacity of this.jar
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     *
     * @return - number of monies in this.jar
     */
    public int getNumberOfMonies() {
        return this.jar.getCurrentSize();
    }

    /**
     * redistributes coin/bill objects randomly
     */
    public void shake() {
        Object[] toShake = this.jar.toArray();
        Random random = new Random();
        double total = 0.00;

        System.out.println(">> Shaking your piggy bank <<");

        for (int i = 0; i < toShake.length; i++) {
            Collections.swap(Arrays.asList(toShake), i, random.nextInt(this.jar.getCurrentSize()));
        }
        while (!this.jar.isEmpty()) {
            this.jar.remove();
        }

        for (Object obj : toShake) {
            this.jar.add((Money) obj);
        }
        System.out.println("\n");
    }

    /**
     * empties the contents of piggy bank while counting how many coin/bill objects landed heads up
     * @return - the number of times object landed heads
     */
    public int emptyPiggyBankAndCountHeads() {
        int heads = 0;
        double total = 0.00;
        Object[] list = this.jar.toArray();
        System.out.println(">> Emptying your piggy bank <<");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
            if (((Money) list[i]).isHeads()) {
                heads++;
                total += ((Money) list[i]).getValue();
            }
            this.jar.remove();
        }for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
            if (((Money) list[i]).isHeads()) {
                heads++;
                total += ((Money) list[i]).getValue();
            }
            this.jar.remove();
        }

        System.out.println(heads + " out of " + list.length + " coins/bills landed \"HEADS\"");
        System.out.println("The total value of \"HEADS\" is: $" + String.format("%.2f", total));
        System.out.printf("\n");
        return heads;
    }

    public String toString() {
        Object[] list = this.jar.toArray();
        double total = 0.00;
        System.out.println(">> The content of your piggy bank <<");
        System.out.print("There are " + list.length + " coins/bills in the piggy bank: [");
        for (int i = 0; i < list.length; i++) {
            total += ((Money) list[i]).getValue();
            System.out.print(list[i].toString() + ", ");
        }
        System.out.println("]");
        System.out.printf("The total of " + String.format("%.2f", total) + "\n\n");
        return "total: " + total;
    }
}
