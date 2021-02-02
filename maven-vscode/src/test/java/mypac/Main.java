package mypac;


/**
 * Hello world!
 *
 */


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        TestPlan.submitForm(); // Workds but was not part of the assignment
        //TestPlan.submitWrongForm(); // Workds but was not part of the assignment
        TestPlan.uploadFile(); // Workds
        TestPlan.checkImage();  // Works
        TestPlan.checkDesignChange(); // Works
        TestPlan.checkTableDOM(); // Works
        TestPlan.cleanUp();
    }
}
