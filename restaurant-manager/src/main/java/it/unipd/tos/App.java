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
		if(itemsOrdered==null) {
			return 0;
		}
		if(itemsOrdered.size()>20) {
			throw new RestaurantBillException("Number Item Exceeded");
		}
		
		double sum=itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();
		
		if(itemsOrdered.stream().filter((a)->a.getType()==itemType.Pizza).count()>10) {
			sum-=itemsOrdered.stream().mapToDouble((a)->{
				if(a.getType()==itemType.Pizza) {
					return a.getPrice();
				}
				else {
					return Double.MAX_VALUE;
				}
			}).min().orElse(0);
		}
		
		if(sum>100) {
			sum=sum*0.95;
		}
		return sum;
	}
}
