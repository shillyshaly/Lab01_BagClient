import java.util.*;

/**
 * implements the Coin object extended from Money
 *
 * @version 2/1/2020
 * @updatedBy Jamie Hernandez
 */

public class Coin extends Money {
    private CoinDenomination coinDenomination;

    public Coin() {
        super();
        Random random = new Random();
        CoinDenomination[] cd = CoinDenomination.values();
        this.coinDenomination = cd[random.nextInt(cd.length)];
    }

    public double getValue() {
        return this.coinDenomination.getCoinValue();
    }

    public String toString() {
        this.toss();
        String coinSide;
        if (!this.isHeads()) {
            coinSide = "TAILS";
        }
        else {
            coinSide = "HEADS";
        }
        return this.coinDenomination.name() + " landed " + coinSide;
    }
}