package obr;

import java.util.List;

public class Customer extends Persons{

	public Customer(String personCode, String firstName, String lastName, Address address,List<String> email) {
		super( personCode, firstName, lastName, address, email);
	}

	public String getSecID(){
		return null;
	}
	public String getType(){
		return null;
	}
}
