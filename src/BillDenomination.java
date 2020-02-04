/**
 * enum type for a Bill object.
 *
 * @author Jamie Hernandez
 * @version 1/28/2020
 */
public enum BillDenomination {
    WASHINGTON(1), JEFFERSON(2), LINCOLN(5), HAMILTION(10),
    JACKSON(20), GRANT(50), FRANKLIN(100);

    private int billValue;

    private BillDenomination(int billValue) {
        this.billValue = billValue;
    }

    public int getBillValue() {
        return this.billValue;
    }

}