////////////////////////////////////////////////////////////////////
// Enrico Cancelli 1143080
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class RestaurantBillTest 
{
	
    @Test
    public void getOrderPrice_NullList_ExpectedZero()throws RestaurantBillException
    {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=null;
    	assertEquals(0,res.getOrderPrice(list),0);
    }
    
    @Test
    public void getOrderPrice_EmptyList_ExpectedZero()throws RestaurantBillException
    {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	assertEquals(0,res.getOrderPrice(list),0);
    }
    
    @Test(expected = RestaurantBillException.class)
    public void getOrderPrice_ListMoreThan20Items_RestaurantBillExceptionThrown()throws RestaurantBillException{
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	for(int i=0;i<21;++i) {
    		list.add(new MenuItem(itemType.Primo,"a",0));
    	}
    	try {
    		assertEquals(list.get(0).getName(),"a");
    		res.getOrderPrice(list);
    	}
    	catch(RestaurantBillException a) {
    		assertEquals("Number Item Exceeded",a.getError());
    		throw a;
    	}
    }
    
    @Test
    public void getOrderPrice_ListLessThan10PizzasAndSumLessThan100_ExpectedSum()throws RestaurantBillException {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	for(int i=0;i<20;++i) {
    		list.add(new MenuItem(itemType.Primo,"a",5));
    	}
    	assertEquals(100,res.getOrderPrice(list),0);
    }
    
    @Test
    public void getOrderPrice_ListMoreThan10PizzasAndSumLessThan100_ExpectedSumWithoutCheapestPizza()throws RestaurantBillException {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	for(int i=0;i<20;++i) {
    		list.add(new MenuItem(itemType.Pizza,"a",5));
    	}
    	assertEquals(95,res.getOrderPrice(list),0);
    }
    
    @Test
    public void getOrderPrice_ListLessThan10PizzasAndSumMoreThan100_ExpectedSumWithDiscount()throws RestaurantBillException {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	for(int i=0;i<10;++i) {
    		list.add(new MenuItem(itemType.Pizza,"a",20));
    	}
    	assertEquals(190,res.getOrderPrice(list),0);
    }
    
    @Test
    public void getOrderPrice_ListMoreThan10PizzasAndSumMoreThan100_ExpectedSumWithoutCheapestPizzaWithDiscount()throws RestaurantBillException {
    	RestaurantBillInterface res=new RestaurantBill();
    	List<MenuItem> list=new ArrayList<MenuItem>();
    	for(int i=0;i<19;++i) {
    		list.add(new MenuItem(itemType.Pizza,"a",10));
    	}
    	list.add(new MenuItem(itemType.Primo,"b",10));
    	assertEquals(180.5,res.getOrderPrice(list),0);
    }
}
