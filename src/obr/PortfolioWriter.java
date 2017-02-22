package obr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PortfolioWriter {
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
			
			//gets the type of the assets
			
			if(a < portInfo.size()) {
				annualReturn.addAll(portInfo.get(a).getAnnualReturn(portInfo.get(a).getAssetList()));
				a++;
			}
			
			
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
		}
		
		write.println(String.format("%-30s %-30s %-30s %-30s %-30s", "Totals", totalFees, totalCommissions, totalReturnValue, totalValue));
		//writes the individual details of each portfolio
		write.println();
		write.println("Portfolio Details");
		for (int z = 0; z < portInfo.size(); z++) {
			write.println("--------------------------------------------------------------------------------------------------------------------------------------");
			write.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
			write.println("Owner: " + portInfo.get(z).getOwnerCode());//FIXME: GET OWNER NAME
			write.println("Manager: " + portInfo.get(z).getManagerCode()); //FIXME: GET MANAGER NAME
			write.println("Beneficiary: " + portInfo.get(z).getBeneficiaryCode()); //FIXME: get ben name
			write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
			try {
				for(int t = 0; t < portInfo.get(z).getAssetList().size(); t++) {
					write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", portInfo.get(z).getAssetList().get(t).getCode(),
							portInfo.get(z).getAssetList().get(t).getLabel(), "D", df.format(portInfo.get(z).getAssetList().get(t).getRiskMeasure()),
							df.format(portInfo.get(z).getAssetList().get(t).getAnnualReturn()), portInfo.get(z).getAssetList().get(t).getCalcValue()));
				}
			}
			catch (NullPointerException e) {
				write.print("");
			}
		}
		write.close();
	}
}
