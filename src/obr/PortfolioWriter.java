package obr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class PortfolioWriter {

	public void PortfolioWriter(List<Portfolios>portInfo, List<Persons> perInfo, List<Assets> assetInfo) {
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
			
			//gets the manager's name
			String managerName = "";
			for(int k = 0; k < perInfo.size(); k++) {
				if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
					managerName = perInfo.get(k).getLastName() + ", " + perInfo.get(k).getFirstName();
					break;
				}
			}
		write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", portInfo.get(i).getPortfolioCode(), ownerName, managerName, "d", "d", "d", "d", "d"));  //use obj.get to access info and print
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
