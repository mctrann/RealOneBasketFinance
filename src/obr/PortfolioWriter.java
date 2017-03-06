package obr;

import java.text.DecimalFormat;
import java.util.List;


public class PortfolioWriter {
<<<<<<< HEAD
<<<<<<< HEAD
	private double fees;
	public void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo, List<Assets> assetInfo) {
		PrintWriter write = null;
=======
	
	//create private variables of class PortfolioWriter
	private double totalFees = 0.0;
	private double totalCommissions = 0.0;
	private double totalReturnValue = 0.0;
	private double totalValue = 0.0; 
	
	public void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo) {
>>>>>>> jjfield3
		
		PrintWriter write = null;
		DecimalFormat df = new DecimalFormat("0.00");
		try{
			write = new PrintWriter("data/output1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		int a = 0;
=======


>>>>>>> jjfield3
		write.println("Porfolio Summary Report");
		write.println("--------------------------------------------------------------------------------------------------------------------------------------");
		write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", "Portfolio", "Owner", "Manager", "Fees", "Comissions", "Weighted Risk", "Return", "Total"));
		for(int i = 0; i < portInfo.size(); i++) {
<<<<<<< HEAD
			
=======

>>>>>>> jjfield3
			//gets the owner's name
			String ownerName = "";
			for(int j = 0; j < perInfo.size(); j++) {
				if(portInfo.get(i).getOwnerCode().equals(perInfo.get(j).getPersonCode())) {
					ownerName = perInfo.get(j).getLastName() + ", " + perInfo.get(j).getFirstName();
					break;
				}
			}

			//gets the manager's name and fees
			String managerName = "";
			double localFees = 0.0;
			double localCommissions = 0.0;
			for(int k = 0; k < perInfo.size(); k++) {
				if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
					managerName = perInfo.get(k).getLastName() + ", " + perInfo.get(k).getFirstName();
					localFees = perInfo.get(k).getFees(portInfo.get(i).getAssetList());
					totalFees = totalFees + localFees;
					localCommissions = localCommissions + perInfo.get(k).getCommissions(portInfo.get(i).getTotalReturnValue(portInfo.get(i).getAssetList()));
					totalCommissions = totalCommissions + localCommissions;
					break;
				}
			}

			double localTotalValue = portInfo.get(i).getTotalValue(portInfo.get(i).getAssetList());
			totalValue = totalValue + localTotalValue;
			
<<<<<<< HEAD
			List<Double> annualReturn = new ArrayList<Double>();
			double totalValue = 0;
=======

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
>>>>>>> TranM
			
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
			
<<<<<<< HEAD
			
			for(int q = 0; q < annualReturn.size(); q++) {
				totalValue = totalValue + annualReturn.get(q);
			}
			//writes in the info
			write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", portInfo.get(i).getPortfolioCode(), ownerName, managerName,"$" + portInfo.get(i).getFees(portInfo.get(i).getManagerCode()) + "0",
					"D", totalValue, "d", "d"));  //use obj.get to access info and print
			fees += portInfo.get(i).getFees(portInfo.get(i).getManagerCode());
=======
			double localReturnValue = portInfo.get(i).getTotalReturnValue(portInfo.get(i).getAssetList());
			totalReturnValue = totalReturnValue + localReturnValue;
			//writes in the info
			write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", portInfo.get(i).getPortfolioCode(), ownerName, managerName, df.format(localFees), 
					df.format(localCommissions), df.format(portInfo.get(i).getRisk(portInfo.get(i).getAssetList())), df.format(localReturnValue), df.format(localTotalValue)));  //use obj.get to access info and print
>>>>>>> jjfield3
=======
			//prints each portfolio's calculations and persons involved
			System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", portInfo.get(i).getPortfolioCode(), portInfo.get(i).getName(portInfo.get(i).getOwnerCode(), perInfo), portInfo.get(i).getName(portInfo.get(i).getManagerCode(), perInfo), "$" +df.format(localFees), 
					"$" + df.format(localCommissions), dflong.format(portInfo.get(i).getRisk(portInfo.get(i).getAssetList())), "$" + df.format(localReturnValue), "$" + df.format(localTotalValue))); 
>>>>>>> TranM
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
<<<<<<< HEAD
			write.println("--------------------------------------------------------------------------------------------------------------------------------------");
			write.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
			write.println("Owner: " + portInfo.get(z).getOwnerCode());
			write.println("Manager: " + portInfo.get(z).getManagerCode());
			write.println("Beneficiary: " + portInfo.get(z).getBeneficiaryCode());
			write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
=======
			System.out.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
			
			System.out.println("Owner: " + portInfo.get(z).getName(portInfo.get(z).getOwnerCode(), perInfo));
			System.out.println("Manager: " + portInfo.get(z).getName(portInfo.get(z).getManagerCode(), perInfo));
	
			for(int j = 0; j < perInfo.size(); j++) {
				if(portInfo.get(z).getBeneficiaryCode().equals(perInfo.get(j).getPersonCode()))  {
					System.out.println("Beneficiary: " + perInfo.get(j).getLastName() + ", " + perInfo.get(j).getFirstName());
					break;
				}
				else if(portInfo.get(z).getBeneficiaryCode().equals("none")) {
					System.out.println("Beneficiary: " + portInfo.get(z).getBeneficiaryCode());
					break;
				}
			}
			//prints calculations for each asset in each portfolio
			System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
>>>>>>> TranM
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
		Data_Converter dc = new Data_Converter(); 
		dc.dataParser();
		PortfolioWrite(dc.getPortInfo(), dc.getPerInfo());
	}
}
