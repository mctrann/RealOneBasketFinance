package obr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
//	public double getTotalReturnValue(List<Assets> assetList) {
//		
//	}
	
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
}
