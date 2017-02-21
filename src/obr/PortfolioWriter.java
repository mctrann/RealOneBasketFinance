package obr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PortfolioWriter {
	public void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo) {
		PrintWriter write = null;

		try{
			write = new PrintWriter("data/output1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		write.println("Porfolio Summary Report");
		write.println("--------------------------------------------------------------------------------------------------------------------------------------");
		write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", "Portfolio", "Owner", "Manager", "Fees", "Comissions", "Weighted Risk", "Return", "Total"));
		for(int i = 0; i < portInfo.size(); i++) {

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
			double fees = 0.0;
			for(int k = 0; k < perInfo.size(); k++) {
				if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
					managerName = perInfo.get(k).getLastName() + ", " + perInfo.get(k).getFirstName();
					fees = perInfo.get(k).getFees(portInfo.get(i).getAssetList());
					break;
				}
			}

			//writes in the info
			write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", portInfo.get(i).getPortfolioCode(), ownerName, managerName, fees, 
					"D", "d", "d", portInfo.get(i).getTotalValue(portInfo.get(i).getAssetList())));  //use obj.get to access info and print
		}

		//writes the individual details of each portfolio
		write.println();
		write.println("Portfolio Details");
		for (int z = 0; z < portInfo.size(); z++) {
			write.println("--------------------------------------------------------------------------------------------------------------------------------------");
			write.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
			write.println("Owner: " + portInfo.get(z).getOwnerCode());
			write.println("Manager: " + portInfo.get(z).getManagerCode());
			write.println("Beneficiary: " + portInfo.get(z).getBeneficiaryCode());
			write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
			try {
				for(int t = 0; t < portInfo.get(z).getAssetList().size(); t++) {
					write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", portInfo.get(z).getAssetList().get(t).getCode(),
							portInfo.get(z).getAssetList().get(t).getLabel(), "Return Rate", portInfo.get(z).getAssetList().get(t).getRiskMeasure(), "Annual Return", portInfo.get(z).getAssetList().get(t).getCalcValue()));
				}
			}
			catch (NullPointerException e) {
				write.println("");
			}
		}
		write.close();
	}
}
