import java.util.*;

/**
 * This class determines how long it would take to remove billiard balls from a poolTable,
 * where ball n is replaced by n balls with randomly generated numbers between 1 and n-1.
 *
 * @version 1/30/2020
 * @updatedBy Jamie Hernandez
 */
public class Billiard
{
    private ResizableArrayBag<Integer> poolTable;

    /**
     * constructor creates this.poolTable object as ResizableArrayBag
     */
    public Billiard()
    {
        this.poolTable = new ResizableArrayBag<>();
    }

    /**
     * prompts the user for the first numbered ball and adds it to this.poolTable
     */
    public void addFirstElement()
    {
        final int SMALLEST_BALL = 1;
        final int LARGEST_BALL = 6;
        Scanner keyboard = new Scanner(System.in);
        int start;
        do
        {
            System.out.println("What is the first numbered ball to start with? (must be between " + SMALLEST_BALL
                    + " and " + LARGEST_BALL + " inclusive)");
            start = keyboard.nextInt();
        } while (!(start >= SMALLEST_BALL && start <= LARGEST_BALL));

        System.out.println("The first ball is: \"" + start + "\"");
        this.poolTable.add(start);
    }

    /**
     * Removes balls from this.poolTable until all are gone.
     */
    public void removeBallsFromTable()
    {
        System.out.println("\n*** Removing balls from the poolTable ***\n");
        final int SEED = 17;
        Random random = new Random(SEED);//        Create Random object
        // TODO Project1


//            otherwise (the ball number is greater than 1)
//                put the “ball number” of randomly generated balls within range of [1 ... ball number – 1] on the table
//                print appropriate message as shown in the sample run

        while(!this.poolTable.isEmpty()){//        Repeat for as long as there are balls on the table:
            Integer ball = this.poolTable.remove();//            remove random ball (call remove() method) and display its value
            System.out.println("Removed ball = " + ball);


            if (ball != 1){
                for (int i = 0; i < ball; i++){
                    this.poolTable.add(random.nextInt(ball -1) + 1);
                }
            }else {
                System.out.println("Removed ball has number \"1\", no new balls will be added");//            if the ball number is 1 just print a message as shown in the sample run
            }
            displayContentOfPoolTable();//        display the content of the bag
        }



        System.out.println("\nThe poolTable is empty!!!");
    } // end removeBallsFromTable

    /**
     * Displays the content of this.poolTable
     */
    private void displayContentOfPoolTable()
    {
        Object[] content = this.poolTable.toArray();
        System.out.println(Arrays.toString(content));
        System.out.println();
    } // end DisplayContentOfPoolTable

    public static void main(String args[])
    {
        Billiard billiard = new Billiard();
        billiard.addFirstElement();

        long startTime = Calendar.getInstance().getTime().getTime(); // get current time in miliseconds

        billiard.removeBallsFromTable();

        long stopTime = Calendar.getInstance().getTime().getTime();

        System.out.println("\nThe time required was " + (stopTime - startTime) + " milliseconds");
    } // end main
} // end Billiard