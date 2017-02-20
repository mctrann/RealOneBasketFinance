package obr;

public class Deposit_Account extends Assets{
	private double apr;	
	//deposit object holds: apr 
	public Deposit_Account(String code, String type, String label,double apr) {
		super(code,type,label);
		// TODO Auto-generated constructor stub
		this.apr = apr;
	}
	public double getAPR() {
		return apr;
	}	
	public void setAPR(double apr) {
		this.apr = apr;
	}
	
	public double getRiskMeasure() {
		return 0;
	}
	
	public double getBRR() {
		
		return Math.pow(Math.E, (getAPR()/100)) - 1;
	}
	
	public double getValue() {
		return 0;
	}
}
