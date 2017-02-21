package obr;

public class Private_Investments extends Assets{
	private double quartDiv;
	private double baseRateOfReturn;
	private double omegaMeasure;
	private double totalValue;
	private double percentageStake;

	public Private_Investments(String code, String type, String label, double quartDiv, double BRR, double omegaMeasure, double totalValue) {
		super(code, type, label); 
		this.omegaMeasure = omegaMeasure;
		this.baseRateOfReturn = BRR;
		this.totalValue = totalValue;
		this.quartDiv = quartDiv;
	}
	
	public Private_Investments(Private_Investments pi) {
		this(pi.getCode(), pi.getType(), pi.getLabel(), pi.getQuartDiv(), pi.getBRR(), pi.getRiskMeasure(), pi.getValue());
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

	public double getRiskMeasure() {
		return omegaMeasure;
	}

	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = omegaMeasure;
	}	 

	public double getValue() {
		return totalValue;
	} 

	public void setPercentageStake(double percentageStake) {
		this.percentageStake = percentageStake;
	}
	
	public double getPercentageStake() {
		return percentageStake;
	}
	
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getCalcValue() {
		double totalValue = 0;
		
		totalValue = getValue() * (getPercentageStake()/100);
		return totalValue;
	}
}
