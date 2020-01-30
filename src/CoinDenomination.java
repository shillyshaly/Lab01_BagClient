/**
 * enum type for a Coin object.
 *
 * @author atb
 * @version 1/28/2020
 */
public enum CoinDenomination
{
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25);
    private double coinValue;

    private CoinDenomination(double coinValue)
    {
        this.coinValue = coinValue;
    }

    public double getCoinValue()
    {
        return this.coinValue;
    }
}
