package obr;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Data_Converter {
	private  static List<Persons> perInfo= new ArrayList<Persons>(); 
	private static List <Assets> assetInfo= new ArrayList<Assets>();
	private static List<Portfolios> portInfo = new ArrayList<Portfolios>();
	// parse persons and assets files
	public static void dataParser(){

		//reads file
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data/Persons.dat"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		//skips first line that is an integer
		String line1 = null;
		int startLine = 1;
		int counter = startLine;
		
		//Parsing Persons.dat into the Persons.java class
		try {
			while((line1 = reader.readLine()) != null) {
				if(counter > startLine) {
					String persons_arr[] = line1.split(";",-1);
					String code = persons_arr[0];
					String broker_data[];
					String brokerPosition;
					String secID;
					if (persons_arr[1].contains(",")){
						broker_data = persons_arr[1].split(",");
						brokerPosition = broker_data[0];
						secID = broker_data[1];
					}
					else{
						brokerPosition="";
						secID="";
					}
					//parsing in persons info
					String name[] = persons_arr[2].split(",");
					String firstName=name[1];
					String lastName=name[0];
					String addressArr[] = persons_arr[3].split(",");
					
					String street=addressArr[0];
					String city=addressArr[1];
					String state=addressArr[2];
					String zipCode=addressArr[3];
					String country=addressArr[4];
					Address address = new Address(street, city,state,country, zipCode);

					List<String>email=new ArrayList<String>();
					if (persons_arr[4]==null){
						email.add("");
					}
					else if (persons_arr[4].contains(",")){
						String temp[]=persons_arr[4].split(",");
						for (int i=0; i<temp.length;i++){
							email.add(temp[i]);
						}
					}
					else {
						email.add(persons_arr[4]);
					}
					//puts new parsed info into appropriate persons object
					if (brokerPosition.equals("J")){
						Junior j;
						perInfo.add(j = new Junior(code,brokerPosition,secID,firstName,lastName, address,email));
					}
					else if (brokerPosition.equals("E")){
						Expert e;
						perInfo.add(e = new Expert(code, brokerPosition, secID,firstName,lastName,address,email));
					}
					else if (brokerPosition.equals("")){
						Customer c;
						perInfo.add(c = new Customer(code,   firstName,  lastName, address, email));
					}
				} 
				counter++;
			}


		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			reader.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}

		//Parsing the Assets.dat file into a Persons.java object
		BufferedReader reader2 = null;

		try {
			reader2 = new BufferedReader(new FileReader("data/Assets.dat"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Invalid Input");
		}

		String line2 = null;
		int startLine2 = 1;
		int counter2 = startLine2;

		try {
			while((line2 = reader2.readLine()) != null) {
				if (counter2 > startLine2) {
					String assets_arr[] = line2.split(";");
					String code = assets_arr[0];
					String type = assets_arr[1];
					String label;
					double quartDiv;
					double BRR;
					double omegaMeasure;
					double totalValue;
					double betaMeasure;
					String stockSymbol;
					double sharePrice;
					double apr;										

					//adds assets to appropriate accounts

					if (type.equals("S")){
						Stocks b;
						label = assets_arr[2];
						quartDiv = Double.parseDouble(assets_arr[3]);
						double tempBRR = Double.parseDouble(assets_arr[4]);
						BRR=tempBRR/100;
						betaMeasure = Double.parseDouble(assets_arr[5]);
						stockSymbol = assets_arr[6];
						sharePrice = Double.parseDouble(assets_arr[7]);
						assetInfo.add(b = new Stocks(code, type, label,quartDiv,BRR,betaMeasure,stockSymbol,sharePrice));
					}
					else if (type.equals("P")){
						Private_Investments b;
						label = assets_arr[2];
						quartDiv = Double.parseDouble(assets_arr[3]);
						BRR = Double.parseDouble(assets_arr[4]);
						omegaMeasure = Double.parseDouble(assets_arr[5]);
						totalValue = Double.parseDouble(assets_arr[6]);
						assetInfo.add(b = new Private_Investments(code, type, label,quartDiv,BRR,omegaMeasure,totalValue));
					}
					else if (type.equals("D")){
						Deposit_Account b;
						label = assets_arr[2];
						apr = Double.parseDouble(assets_arr[3]);
						assetInfo.add(b = new Deposit_Account(code, type, label,apr));
					}
				}
				counter2++;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	BufferedReader reader3 = null;
		
		try {
			reader3 = new BufferedReader(new FileReader("data/Portfolio.dat"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Invalid Input");
		}
		
		String line3 = null;
		int startLine3 = 1;
		int counter3 = startLine3;
		
		try {
			while((line3 = reader3.readLine()) != null) {
				if (counter3 > startLine3) {
					String portArr[] = line3.split(";");
					String portCode = portArr[0];
					String ownerCode = portArr[1];
					String mangerCode = portArr[2];
					String benCode;
					if(portArr[3].equals("")) {
						benCode = null;
					}
					else {
						benCode = portArr[3];
					}
					
					String assetList[] = portArr[4].split(",");
					HashMap<String, Double> assetList1 = new HashMap<String, Double>();
					if(assetList[0].equals("")) {
						assetList1.put(null, null);
					}
					else {
						for(int i = 0; i < assetList.length; i++) {
							String tempAsset[] = assetList[i].split(":");
							assetList1.put(tempAsset[0], Double.parseDouble(tempAsset[1]));
						}
					}
					Portfolios port;
					portInfo.add(port = new Portfolios(portCode, ownerCode, mangerCode, benCode, assetList1, perInfo, assetInfo));
				}
				counter3++;
			}
			
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			reader3.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public List<Persons> getPerInfo() {
		return perInfo;
	}
	//runs program
	public static void main(String args[]){	
		dataParser();
		JSONWriter thing = new JSONWriter();
		thing.JSONConverterP(perInfo);
		XMLWriter thing2= new XMLWriter();
		thing2.xmlPersonConverter(perInfo);
		thing.JSONconverterA(assetInfo);
		thing2.xmlAssetConverter(assetInfo);
		PortfolioWriter thing3 = new PortfolioWriter();
		thing3.PortfolioWriter(portInfo, perInfo, assetInfo);	
		}
		
}


	