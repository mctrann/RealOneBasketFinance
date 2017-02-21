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

	public double getCommissions(double totalReturnValue) {
		double commission = totalReturnValue * .05;
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
				fee = counter * 10;
			}
			counter++;
		}

		return fee;
	}

}
