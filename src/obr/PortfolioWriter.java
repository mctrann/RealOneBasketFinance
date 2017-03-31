package obr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class PortfolioWriter {
	private static List<Portfolios> portInfo= new ArrayList<Portfolios>();
	private static List<Persons> perInfo= new ArrayList<Persons>();
	//create private variables of class Portfolios
	private static double totalFees = 0.0;
	private static double totalCommissions = 0.0;
	private static double totalReturnValue = 0.0;
	private static double totalValue = 0.0; 
	
	public static void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo) {
		//formats decimals
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat dflong = new DecimalFormat("0.0000");
		
		//prints summary of portfolios
		System.out.println("Porfolio Summary Report");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", "Portfolio", "Owner", "Manager", "Fees", "Comissions", "Weighted Risk", "Return", "Total"));
		for(int i = 0; i < portInfo.size(); i++) {
			double localTotalValue = portInfo.get(i).getTotalValue(portInfo.get(i).getAssetList());
			totalValue = totalValue + localTotalValue;

			double localReturnValue = portInfo.get(i).getTotalReturnValue(portInfo.get(i).getAssetList());
			totalReturnValue = totalReturnValue + localReturnValue;
			
			double localFees = 0.0;
			double localCommissions = 0.0;
			
			//calculates total commissions and fees
			for(int k = 0; k < perInfo.size(); k++	) {
				 if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
					 
				localFees = perInfo.get(k).getFees(portInfo.get(i).getAssetList());
				totalFees = totalFees + localFees;
				
				localCommissions = perInfo.get(k).getCommissions(portInfo.get(i).getTotalReturnValue(portInfo.get(i).getAssetList()));
				totalCommissions = totalCommissions + localCommissions;
				}
			}
			
			//prints each portfolio's calculations and persons involved
			System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", portInfo.get(i).getPortfolioCode(), portInfo.get(i).getName(portInfo.get(i).getOwnerCode(), perInfo), portInfo.get(i).getName(portInfo.get(i).getManagerCode(), perInfo), "$" +df.format(localFees), 
					"$" + df.format(localCommissions), dflong.format(portInfo.get(i).getRisk(portInfo.get(i).getAssetList())), "$" + df.format(localReturnValue), "$" + df.format(localTotalValue))); 
		}

		
		//prints total fees, commissions, return, and value of all portfolios
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", "", "", "Totals", "$" + df.format(totalFees), "$" + df.format(totalCommissions), "", "$" + df.format(totalReturnValue), df.format(totalValue)));
		
		//System.outs the individual details of each portfolio
		System.out.println();
		System.out.println("Portfolio Details");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		//outputs portfolio code, manger, owner, and beneficiary's name
		for (int z = 0; z < portInfo.size(); z++) {
			System.out.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
			
			System.out.println("Owner: " + portInfo.get(z).getName(portInfo.get(z).getOwnerCode(), perInfo));
			System.out.println("Manager: " + portInfo.get(z).getName(portInfo.get(z).getManagerCode(), perInfo));
	
			for(int j = 0; j < perInfo.size(); j++) {
				if(portInfo.get(z).getBeneficiaryCode().equals(perInfo.get(j).getPersonCode()))  {
					System.out.println("Beneficiary: " + perInfo.get(j).getLastName() + ", " + perInfo.get(j).getFirstName());
					break;
				}
				else if(portInfo.get(z).getBeneficiaryCode().equals("")) {
					System.out.println("Beneficiary: " + "none");
					break;
				}
			}
			//prints calculations for each asset in each portfolio
			System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
			try {
				for(int t = 0; t < portInfo.get(z).getAssetList().size(); t++) {
					System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", portInfo.get(z).getAssetList().get(t).getCode(),
							portInfo.get(z).getAssetList().get(t).getLabel(), df.format(portInfo.get(z).getAssetList().get(t).getReturnRate()) + "%", df.format(portInfo.get(z).getAssetList().get(t).getRiskMeasure()),
							"$" + df.format(portInfo.get(z).getAssetList().get(t).getAnnualReturn()), "$" + df.format(portInfo.get(z).getAssetList().get(t).getCalcValue())));
				}
			}
			catch (NullPointerException e) {
				System.out.print("");
			}
			//prints the totals of a particular portfolio
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", "","","Totals", dflong.format(portInfo.get(z).getRisk(portInfo.get(z).getAssetList())), "$" + df.format(portInfo.get(z).getTotalReturnValue(portInfo.get(z).getAssetList())), "$" + df.format(portInfo.get(z).getTotalValue(portInfo.get(z).getAssetList()))));
		}
	}
	
	public static void main(String args[]){	
		
		DataReceiver dr = new DataReceiver();
		
		perInfo.addAll(dr.getPerson());
		portInfo.addAll(dr.getPortfolio());
		PortfolioWrite(portInfo,perInfo);
	}
}
