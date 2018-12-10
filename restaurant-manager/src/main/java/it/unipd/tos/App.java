////////////////////////////////////////////////////////////////////
// Enrico Cancelli 1143080
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import java.util.List;

import it.unipd.tos.business.RestaurantBill;
import it.unipd.tos.business.exception.RestaurantBillException;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;
/**
 * Hello world!
 *
 */
public class App implements RestaurantBill
{
	@Override
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
		if(itemsOrdered.size()>20) {
			throw new RestaurantBillException("Number Item Exceeded");
		}
		
		double sum=itemsOrdered.stream().mapToDouble(MenuItem::getPrice).min().orElseThrow(()->new RestaurantBillException("Min not Found"));
		
		if(itemsOrdered.stream().mapToInt((a)->{
			if(a.getType()==itemType.Pizza) {
				return 1;
			}
			else {
				return 0;
			}
		}).sum()>10) {
			sum-=itemsOrdered.stream().mapToDouble((a)->{
				if(a.getType()==itemType.Pizza) {
					return a.getPrice();
				}
				else {
					return Double.MAX_VALUE;
				}
			}).min().orElseThrow(()->new RestaurantBillException("Min not Found"));
		}
		
		if(sum>100) {
			sum=sum*0.95;
		}
		return sum;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
