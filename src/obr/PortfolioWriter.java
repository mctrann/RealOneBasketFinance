package obr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioWriter {
	private double fees;
	public void PortfolioWrite(List<Portfolios>portInfo, List<Persons> perInfo, List<Assets> assetInfo) {
		DecimalFormat df = new DecimalFormat("0.00");
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
			
			//gets the return
			double totalReturnValue = 0;
			double totalValue = 0;
			HashMap<String, Double> assetHash = new HashMap<String, Double>();
			assetHash.putAll(portInfo.get(i).getAssetList());

			for(Map.Entry<String, Double> entry : assetHash.entrySet()) {
				totalReturnValue = totalReturnValue + portInfo.get(i).getAnnualReturn(entry.getKey(), entry.getValue());
				totalValue = totalValue + portInfo.get(i).getTotalValue(entry.getKey(), entry.getValue());
			}
			
			double commission = 0;
			commission = portInfo.get(i).getCommissions(portInfo.get(i).getManagerCode(), totalReturnValue);
			
			write.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s", portInfo.get(i).getPortfolioCode(), ownerName, managerName,"$" + portInfo.get(i).getFees(portInfo.get(i).getManagerCode()),
					commission, "Risk", df.format(totalReturnValue), df.format(totalValue)));  //use obj.get to access info and print
			fees += portInfo.get(i).getFees(portInfo.get(i).getManagerCode());
		}

		//Writes the individual portfolios
		write.println("Portfolio Details");
		for (int z = 0; z < portInfo.size(); z++) {
			write.println("--------------------------------------------------------------------------------------------------------------------------------------");
			write.println("Portfolio " + portInfo.get(z).getPortfolioCode());
			write.println("Owner: " + portInfo.get(z).getOwnerCode());
			write.println("Manager:" + portInfo.get(z).getManagerCode());
			write.println("Beneficiary: " + portInfo.get(z).getBeneficiaryCode());
			write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));

			//creates new HashMap of the instance z of portInfo
			HashMap<String, Double> assetHash = new HashMap<String, Double>();
			assetHash.putAll(portInfo.get(z).getAssetList());

			//Goes through the HashMap at instance z of portInfo
			double totalValue = 0.0;
			double totalReturnRate = 0.0;
			for(Map.Entry<String, Double> key : assetHash.entrySet()) {

				for(int t = 0; t < assetInfo.size(); t++) {
					if(key.getKey().equals(assetInfo.get(t).getCode())) {
						if(assetInfo.get(t).getType().equals("S")) {
							write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", key.getKey(), assetInfo.get(t).getLabel(), "d", df.format(assetInfo.get(t).getRiskMeasure()), df.format(portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue())), df.format(assetInfo.get(t).getValue() * key.getValue())));
							totalValue = totalValue + (assetInfo.get(t).getValue() * key.getValue());
							totalReturnRate = totalReturnRate + portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue());
							break;
						}
						else if(assetInfo.get(t).getType().equals("D")) {
							write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", key.getKey(), assetInfo.get(t).getLabel(), "d", df.format(assetInfo.get(t).getRiskMeasure()), df.format(portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue())), df.format(key.getValue())));
							totalValue = totalValue + key.getValue();
							totalReturnRate = totalReturnRate + portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue());
							break;
						}
						else if (assetInfo.get(t).getType().equals("P")) {
							write.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s", key.getKey(), assetInfo.get(t).getLabel(), "d", df.format(assetInfo.get(t).getRiskMeasure()), df.format(portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue())), df.format(assetInfo.get(t).getValue() * (key.getValue()/100))));
							totalValue = totalValue + (assetInfo.get(t).getValue() * (key.getValue()/100));
							totalReturnRate = totalReturnRate + portInfo.get(z).getAnnualReturn(key.getKey(), key.getValue());
							break;
						}
						else {

						}
					}
				}
			}
			write.println(String.format("%-10s %-10s %-10s %-10s", "Totals", "d", df.format(totalReturnRate), df.format(totalValue)));
		}

		//closes the PrinteWriter
		write.close();
	}
}
