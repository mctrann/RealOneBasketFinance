package obr;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataReceiver dr= new DataReceiver();
//		ArrayList <Private_Investments> da= new ArrayList<Private_Investments>();
//		da.addAll(dr.getPIList());
//		for (Private_Investments p: da){
//			System.out.println(p.getLabel());
//		}
		
		ArrayList<Persons> p = new ArrayList<Persons>();
		p.addAll(dr.getPerson());
		for(Persons pr: p) {
			System.out.println(pr.getFirstName());
		}
	}

}
