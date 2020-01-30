/**
 * A class that implements a piggy bank full exception.
 *
 * @author atb
 * @version 1/28/2020
 */
public class PiggyBankFullException  extends RuntimeException
{

    /**
     * Constructor for objects of class PiggyBankFullException
     */
    public PiggyBankFullException(String reason)
    {
        super(reason);
    }
}
