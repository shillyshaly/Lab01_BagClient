import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

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

    public PiggyBank(int numberOfMonies, int capacity) {
        this.jar = new ResizableArrayBag<>();
        this.capacity = capacity;

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
    }

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

    public boolean isEmpty() {
        return this.jar.isEmpty();
    }

    public boolean isFull() {
        boolean full = false;
        if (this.jar.getCurrentSize() >= capacity) {
            full = true;
        }
        return full;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getNumberOfMonies() {
        return this.jar.getCurrentSize();
    }

    public void shake() {
        Object[] toShake = this.jar.toArray();
        Random random = new Random();

        for (int i = 0; i < toShake.length; i++) {
            Collections.swap(Arrays.asList(toShake), i, random.nextInt(this.jar.getCurrentSize()));
        }
        while (!this.jar.isEmpty()) {
            this.jar.remove();
        }
        for (Object obj : toShake) {
            this.jar.add((Money) obj);
        }
    }

    public int emptyPiggyBankAndCountHeads() {
        int heads = 0;
        double total = 0.00;
        Object[] list = this.jar.toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
            if (((Money) list[i]).isHeads()) {
                heads++;
                total += ((Money) list[i]).getValue();
            }
            this.jar.remove();
        }

        System.out.println(heads + " out of " + list.length + " coins/bills landed \"HEADS\"");
        System.out.println("The total value of \"HEADS\" is: $" + String.format("%.2f", total));
        return heads;
    }

    public String toString() {
        Object[] list = this.jar.toArray();
        double total = 0.00;
        System.out.print("There are " + list.length + " coins/bills in the piggy bank: [");
        for (int i = 0; i < list.length; i++) {
            total += ((Money) list[i]).getValue();
            System.out.print(list[i].toString() + ", ");
        }
        System.out.println("]");
        System.out.println("The total of " + String.format("%.2f", total));
        return "total: " + total;
    }
}
