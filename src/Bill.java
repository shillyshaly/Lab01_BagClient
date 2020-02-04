import java.util.Random;
/**
 * create a Bill object.
 *
 * @author Jamie Hernandez
 * @version 1/28/2020
 */

public class Bill extends Money {
    private BillDenomination billDenomination;

    /**
     *  Bill constructor that creates a Bill object with random denomination
     */

    public Bill() {
        super();
        Random random = new Random();
        BillDenomination[] bd = BillDenomination.values();
        this.billDenomination = bd[random.nextInt(bd.length)];
    }

    /**
     *
     * @return value of Bill denomination
     */
    public double getValue() {
        return this.billDenomination.getBillValue();
    }

    /**
     *
     * @return bill denomination and what side it landed (heads/tails)
     */
    public String toString() {
        this.toss();
        String billSide;
        if (!this.isHeads()) {
            billSide = "TAILS";
        }
        else {
            billSide = "HEADS";
        }
        return this.billDenomination.name() + " landed " + billSide;
    }
}
