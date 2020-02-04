/**
 * A client class that implements a piggy bank functionality.
 *
 * @author Jamie Hernandez
 * @version 2/2/2020
 */
public class Round {
    // TODO Project2 - the next line is commented out so the class compiles for now - DONE
    // TODO Project2 - uncomment once PiggyBank class is implemented - DONE
    private PiggyBank myPiggyBank;
    private Money coin;
    private Money bill;

    public Round(int numberOfMonies, int capacity) {
        // TODO Project2
        myPiggyBank = new PiggyBank(numberOfMonies, capacity);
        myPiggyBank.toString();
    }

    public void addCoinAndBill() {
        // TODO Project2
        coin = new Coin();
        bill = new Bill();
        try {
            this.myPiggyBank.add(coin);
            this.myPiggyBank.add(bill);
        } catch (PiggyBankFullException f) {
            System.out.println("piggy bank is full - cannot add any more monies");
            f.printStackTrace();
        }

    }


    public int play() {
        // TODO Project2
        addCoinAndBill();
        this.myPiggyBank.shake();
        this.myPiggyBank.toString();

        return this.myPiggyBank.emptyPiggyBankAndCountHeads();
    }

}