package obr;

import java.util.List;

//junior broker
public class Junior extends Persons {
	private String type;
	private String secID;
	public Junior(String personCode, String broker_position, String secID, String firstName, String lastName,Address address,List<String>email) {
		super(personCode, firstName, lastName, address,email);
		this.secID=secID;
		this.type=broker_position;
	}
	public String getSecID(){
		return this.secID;
	}
	public String getType(){
		return this.type;
	}

}
