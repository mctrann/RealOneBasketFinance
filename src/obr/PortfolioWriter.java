package obr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PortfolioWriter {
	private double fees;
	public void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo, List<Assets> assetInfo) {
		PrintWriter write = null;
		
		try{
			write = new PrintWriter("data/output1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int a = 0;
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
			
			//gets the manager's name
			String managerName = "";
			for(int k = 0; k < perInfo.size(); k++) {
				if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
					managerName = perInfo.get(k).getLastName() + ", " + perInfo.get(k).getFirstName();
					break;
				}
			}
			
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
		}
		
//		for (int z = 0; z < portInfo.size(); z++) {
//			System.out.println("Portfolio Details");
//			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
//			System.out.println("Portfolio " + portInfo.get(z).getPortfolioCode());
//			System.out.println("------------------------------------------------------");
//		}
		write.close();
	}
//	public void PortofolioWriter(List<Portfolios>portInfo, List<Persons> perInfo, List<Assets> assetInfo) {
//		
//		PortfolioFormatter(portInfo, perInfo, assetInfo);
//	
//		
//	}

}
