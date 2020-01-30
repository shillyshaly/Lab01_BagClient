/**
 * A class that implements a piggy bank full exception.
 *
 * @author atb
 * @version 1/28/2020
 */
public class PiggyBankEmptyException  extends RuntimeException
{

    /**
     * Constructor for objects of class PiggyBankEmptyException
     */
    public PiggyBankEmptyException(String reason)
    {
        super(reason);
    }
}
