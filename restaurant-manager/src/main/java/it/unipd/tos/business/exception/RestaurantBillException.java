////////////////////////////////////////////////////////////////////
// Enrico Cancelli 1143080
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class RestaurantBillException extends Exception {
private String error;
public RestaurantBillException(String error) {
	this.error=error;
}
public String getError() {
	return error;
}
}
