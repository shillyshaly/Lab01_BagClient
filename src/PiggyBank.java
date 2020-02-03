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

        if (numberOfMonies >= capacity){
            numberOfMonies = capacity;
        }
        for (int i = 0; i < numberOfMonies; i++) {
            Money coin = new Coin();
            Money bill = new Bill();
            Random random = new Random();

            if (random.nextInt(2) == 0) {
                this.jar.add(coin);
                System.out.println("Added $" + String.format("%.2f",coin.getValue()) + " to the piggy bank");
            }
            else {
                this.jar.add(bill);
                System.out.println("Added $" + String.format("%.2f",bill.getValue()) + " to the piggy bank.");
            }
        }
    }

    public void add(Money money) {
        try {
            if (this.jar.getCurrentSize() >= capacity) {
                throw new PiggyBankFullException("Piggy bank is full.");
            }
            else {
                this.jar.add(money);
            }
        } catch (PiggyBankFullException f) {
            f.printStackTrace();
        }
    }

    public Money remove() {
        try{
            if (this.jar.getCurrentSize() <= 0){
                throw new PiggyBankEmptyException("Piggy bank is empty.:");
            }
        }catch (PiggyBankEmptyException e){
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

        for (int i = 0; i < toShake.length; i++){
            Collections.swap(Arrays.asList(toShake), i, random.nextInt(this.jar.getCurrentSize()) + 1);
        }
        while (!this.jar.isEmpty()){
            this.jar.remove();
        }
        for (Object obj : toShake){

        }
    }

    public int emptyPiggyBankAndCountHeads() {
        return 0;
    }

    public String toString() {
        Object[] list = this.jar.toArray();
        double total = 0.00;
        for (int i = 0; i < list.length; i++){
            total += ((Money) list[i]).getValue();
        }
        return null;
    }
}
