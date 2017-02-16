package obr;

import java.util.List;
//Expert broker class
public class Expert extends Persons {
	
	private String secID;
	private String type;
	
	public Expert(String personCode, String broker_position, String secID, String firstName, String lastName, Address address,List<String> email) {
		super( personCode,firstName, lastName,address, email);
		this.type=broker_position;
		this.secID=secID;
		
	}
	public String getSecID(){
		return this.secID;
	}
	public String getType(){
		return this.type;
	}


}
