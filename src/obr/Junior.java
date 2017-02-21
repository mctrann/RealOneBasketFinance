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

	public double getCommissions(double totalReturnValue) {
		double commission = totalReturnValue * .02;
		return commission;
	}
	
	public double getFees(List<Assets> arrayList) {
		double fee = 0.0;
		int counter = 1;
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) == null) {
				fee = 0.0;
				break;
			}
			else {
				fee = counter * 50;
			}
			counter++;
		}
		counter = 0;
		return fee;
	}
}
