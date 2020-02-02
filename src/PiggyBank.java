import java.util.Random;

public class PiggyBank {
    private ResizableArrayBag<Money> jar;
    private int capacity;

    public PiggyBank(int numberOfMonies, int capacity){
        this.jar = new ResizableArrayBag<>();
        this.capacity = capacity;
    }

    public void add(Money money){
        this.jar.add(money);
    }

    public Money remove(){
        return this.jar.remove();
    }

    public boolean isEmpty(){
        return this.jar.isEmpty();
    }

    public boolean isFull(){
        boolean full = false;
        if (this.jar.getCurrentSize() == capacity){
            full = true;
        }
        return full;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getNumberOfMonies(){
        return this.jar.getCurrentSize();
    }

    public void shake(){
        Object[] toShake = this.jar.toArray();
    }

    public int emptyPiggyBankAndCountHeads(){
        return 0;
    }

    public String toString(){
        return null;
    }
}
