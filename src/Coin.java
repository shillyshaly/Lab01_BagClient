import java.util.*;


public class Coin extends Money{
    private CoinDenomination coinDenomination;
    public Coin(){
        super();
        Random random = new Random();
        CoinDenomination[] cd = CoinDenomination.values();
        this.coinDenomination = cd[random.nextInt(cd.length)];
    }

    public double getValue() {
        return 0;
    }

    public String toString() {
        return null;
    }
}