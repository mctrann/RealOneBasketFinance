package obr;

import java.util.HashMap;
import java.util.Map;

public class Portfolios {
	
	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private Map assetList = new HashMap<>();
	
	public Portfolios(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			Map assetList) {
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assetList = assetList;
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

	public Map getAssetList() {
		return assetList;
	}

}
