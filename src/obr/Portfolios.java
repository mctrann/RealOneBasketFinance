package obr;

import java.util.List;


public class Portfolios {

	//create private variables
	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private List<Assets> assetList;

	//create constructor
	public Portfolios(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			List<Assets> assetList){
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assetList = assetList;
	}

	//method for returning the portfolio code
	public String getPortfolioCode() {
		return portfolioCode;
	}

	//method for returning the owner dode
	public String getOwnerCode() {
		return ownerCode;
	}

	//method for returning the manager code
	public String getManagerCode() {
		return managerCode;
	}

	//method for returning the beneficiary code
	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}

	//method for returning the list of Assets
	public List<Assets> getAssetList() {
		return assetList;
	}

	//method to calculate to get total annual return value 
	public double getTotalReturnValue(List<Assets> assetList) {
		double totalReturnValue = 0.0;

		for(int i = 0; i < assetList.size(); i++) {
			if(assetList.get(i) == null) {
				totalReturnValue = 0.0;
			}
			else {
				totalReturnValue = totalReturnValue + assetList.get(i).getAnnualReturn();
			}
		}
		return totalReturnValue;
	}

	//method to calculate the total value of a particular portfolio
	public double getTotalValue(List<Assets> assetList) {
		double totalValue = 0.0;

		for(int i = 0; i < assetList.size(); i++) {
			if(assetList.get(i) == (null)){
				totalValue = 0.0;
			}else{
				totalValue = totalValue + assetList.get(i).getCalcValue();
			}
		}

		return totalValue;
	}
	
//	public double getCommisions() {
//		for()
//	}
//
//	
//	public double getReturn() {
//		
//	}
//	
	public List<Double> getAnnualReturn(HashMap<String, Double> assetList) {

	//method to calculate total risk of portfolio
	public double getRisk(List<Assets> assetList) {
		double totalValue = 0.0;
		
		//calculate totalValue of all assets in one portfolio
		for(int i = 0; i < assetList.size(); i++) {
			if(assetList.get(i) == (null)) {
				totalValue = 0.0;
			}
			else {
				totalValue = totalValue + assetList.get(i).getCalcValue();
			}

		}

		//calculates aggregate risk measure with total value calculated above
		double riskMeasure = 0.0;
		for(int i = 0; i < assetList.size(); i++) {
			if(totalValue == 0) {
				riskMeasure = 0.0;
				break;
			}
			else{
				riskMeasure = riskMeasure + (assetList.get(i).getRiskMeasure() * (assetList.get(i).getCalcValue()/totalValue));
			}
		}

		return riskMeasure;
	}

	//method to get name corresponding to personCode
	public String getName(String personCode, List<Persons> perInfo) {
		String name = "";
		for(int i = 0; i < perInfo.size(); i++) {
			if(personCode.equals(perInfo.get(i).getPersonCode())) {
				name = perInfo.get(i).getLastName() + "," + perInfo.get(i).getFirstName();
			}
		}
		return name;
	}
}
