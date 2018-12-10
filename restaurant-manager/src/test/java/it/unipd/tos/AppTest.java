////////////////////////////////////////////////////////////////////
// Enrico Cancelli 1143080
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

//import junit.framework.Test;
import org.junit.Test;
import static org.junit.Assert.fail;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    //extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    //public AppTest( String testName )
    //{
        //super( testName );
    //}

    /**
     * @return the suite of tests being tested
     */
    //public static Test suite()
    //{
        //return new TestSuite( AppTest.class );
    //}

    /**
     * Rigourous Test :-)
     */
    @Test
    public void getOrderPrice_EmptyList_ExpectedZero()
    {
    	fail("Not implemented");
    }
    
    @Test
    public void getOrderPrice_ListMoreThan20Items_RestaurantBillExceptionThrown() {
    	fail("Not Implemented");
    }
    
    @Test
    public void getOrderPrice_ListLessThan10PizzasAndSumLessThan100_ExpectedSum() {
    	fail("Not Implemented");
    }
    
    @Test
    public void getOrderPrice_ListMoreThan10PizzasAndSumLessThan100_ExpectedSumWithoutCheapestPizza() {
    	fail("Not Implemented");
    }
    
    @Test
    public void getOrderPrice_ListLessThan10PizzasAndSumMoreThan100_ExpectedSumWithDiscount() {
    	fail("Not Implemented");
    }
    
    @Test
    public void getOrderPrice_ListMoreThan10PizzasAndSumMoreThan100_ExpectedSumWithoutCheapestPizzaWithDiscount() {
    	fail("Not Implemented");
    }
}
