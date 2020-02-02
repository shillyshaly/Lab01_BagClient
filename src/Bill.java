import java.util.Random;

public class Bill extends Money {
    private BillDenomination billDenomination;
    public Bill(){
        super();
        Random random = new Random();
        BillDenomination[] bd = BillDenomination.values();
        this.billDenomination = bd[random.nextInt(bd.length)];
    }

    public double getValue() {
        return 0;
    }
    public String toString() {
        return null;
    }
}
