package obr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolios {

	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private HashMap<String, Double> assetList = new HashMap<String, Double>();
	private List<Persons> perInfo = new ArrayList<Persons>();
	private List<Assets> assetInfo = new ArrayList<Assets>();

	public Portfolios(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			HashMap<String, Double> assetList, List<Persons> perInfo, List<Assets> assetInfo){
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assetList = assetList;
		this.perInfo = perInfo;
		this.assetInfo = assetInfo;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}

	public HashMap getAssetList() {
		return assetList;
	}

	public double getFees(String mangerCode) {
		int countArr = 0;
		for(int i = 0; i < assetList.size(); i++) {
			countArr += 1;
		}

		double fee = 0.0;
		for(int i = 0; i < perInfo.size(); i++) {
			if(managerCode.equals(perInfo.get(i).getPersonCode())) {
				if(perInfo.get(i).getType().equals("E")) {
					fee = countArr * 50;
				}
				else if(perInfo.get(i).getType().equals("J")) {
					fee = countArr * 10;
				}
			}
		}

		return fee;
	}

	public double getCommissions(String managerCode, double totalReturnValue) {
		double commission = 0;
		for(int i = 0; i < perInfo.size(); i++) {
			if(managerCode.equals(perInfo.get(i).getPersonCode())) {
				if(perInfo.get(i).getType().equals("E")) {
					commission = totalReturnValue * .05;
				}
				else {
					commission = totalReturnValue * .02;
				}
			}
		}
		return commission;
	}

	public double getAnnualReturn(String key, Double value) {
		double annualReturn = 0;

		for(int i = 0; i < assetInfo.size(); i++) {
			if(key.equals(assetInfo.get(i).getCode())) {
				if(assetInfo.get(i).getType().equals("S")) {
					annualReturn = assetInfo.get(i).getBRR() * (assetInfo.get(i).getValue() * value + (4 * assetInfo.get(i).getQuartDiv()));
					break;
				}
				else if(assetInfo.get(i).getType().equals("D")) {
					annualReturn = assetInfo.get(i).getBRR() * value;
					break;
				}
				else{
					annualReturn =  assetInfo.get(i).getBRR() * (assetInfo.get(i).getValue() * value + (4 * assetInfo.get(i).getQuartDiv()));
					break;
				}

			}
		}
		return annualReturn;
	}

	public double getTotalValue(String key, Double value) {
		double totalValue = 0;

		for(int i = 0; i < assetInfo.size(); i++) {
			if(key.equals(assetInfo.get(i).getCode())) {
				if(assetInfo.get(i).getType().equals("S")) {
					totalValue= assetInfo.get(i).getValue() * value;
					break;
				}
				else if(assetInfo.get(i).getType().equals("D")) {
					totalValue = value;
					break;
				}
				else{
					totalValue = assetInfo.get(i).getValue() * (value/100);
					break;
				}
			}
		}
		return totalValue;
	}
}
