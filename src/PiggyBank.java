import java.util.Random;

public class PiggyBank {
    private ResizableArrayBag<Money> jar;
    private int capacity;

    public PiggyBank(int numberOfMonies, int capacity) {
        this.jar = new ResizableArrayBag<>();
        this.capacity = capacity;

        if (numberOfMonies >= capacity){
            numberOfMonies = capacity;
        }
        for (int i = 0; i <= numberOfMonies; i++) {
            Money coin = new Coin();
            Money bill = new Bill();
            Random random = new Random();

            if (random.nextInt(2) == 0) {
                this.jar.add(coin);
            }
            else {
                this.jar.add(bill);
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
    }

    public int emptyPiggyBankAndCountHeads() {
        return 0;
    }

    public String toString() {
        return null;
    }
}
