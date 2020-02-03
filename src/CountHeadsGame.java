import java.util.*;

/**
 * @author atb
 * @version 1/28/2020
 */
public class CountHeadsGame
{
    public static void main(String[] args)
    {
        PiggyBank bank = new PiggyBank(4,6);
        Money coin = new Coin();
        Money bill = new Bill();
        bank.remove();
        System.out.println("number of monies: " + bank.getNumberOfMonies());
        System.out.println("capacity: " + bank.getCapacity());
        bank.add(coin);
        System.out.println("number of monies: " + bank.getNumberOfMonies());
        bank.add(bill);
        System.out.println("number of monies: " + bank.getNumberOfMonies());
    }
}
