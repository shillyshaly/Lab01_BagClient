import java.util.Random;
/**
 * create a Bill object.
 *
 * @author Jamie Hernandez
 * @version 1/28/2020
 */

public class Bill extends Money {
    private BillDenomination billDenomination;

    public Bill() {
        super();
        Random random = new Random();
        BillDenomination[] bd = BillDenomination.values();
        this.billDenomination = bd[random.nextInt(bd.length)];
    }

    public double getValue() {
        return this.billDenomination.getBillValue();
    }

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
