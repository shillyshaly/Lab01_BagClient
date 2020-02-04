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

    /**
     * round constructor, creates piggy bank and displays the contents
     * @param numberOfMonies
     * @param capacity
     */
    public Round(int numberOfMonies, int capacity) {
        // TODO Project2
        myPiggyBank = new PiggyBank(numberOfMonies, capacity);
        myPiggyBank.toString();
    }

    /**
     * adds a coin and a bill to this.myPiggyBank
     */
    public void addCoinAndBill() {
        // TODO Project2
        coin = new Coin();
        bill = new Bill();
        System.out.println("--> Adding on more coin and one more bill: ");
        try {
            this.myPiggyBank.add(coin);
            this.myPiggyBank.add(bill);
        } catch (PiggyBankFullException f) {
            System.out.println("piggy bank is full - cannot add any more monies");
            f.printStackTrace();
        }
        System.out.printf("\n");
    }

    /**
     * adds a coin and a bill to this.myPiggyBank, shakes the piggy bank, displays the contents
     * and empties the piggy bank.
     * @return - how many coins/bills landed heads
     */
    public int play() {
        // TODO Project2
        addCoinAndBill();
        this.myPiggyBank.shake();
        this.myPiggyBank.toString();

        return this.myPiggyBank.emptyPiggyBankAndCountHeads();
    }

}