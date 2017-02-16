package obr;

public class Private_Investments extends Assets{
	private double quartDiv;
	private double baseRateOfReturn;
	private double omegaMeasure;
	private double totalValue;


	public Private_Investments(String code, String type, String label, double quartDiv, double BRR, double omegaMeasure, double totalValue) {
		super(code, type, label); 
		this.omegaMeasure = omegaMeasure;
		this.baseRateOfReturn = BRR;
		this.totalValue = totalValue;
		this.quartDiv = quartDiv;
	}
	public double getQuartDiv() {
		return quartDiv;
	}

	public void setQuartDiv(double quartDiv) {
		this.quartDiv = quartDiv;
	}

	public double getBRR() {
		return baseRateOfReturn;
	}

	public void setBRR(double BRR) {
		this.baseRateOfReturn = BRR;
	} 

	public double getOmegaMeasure() {
		return omegaMeasure;
	}

	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = omegaMeasure;
	}	 

	public double getTotalValue() {
		return totalValue;
	} 

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
