package obr;

public class Deposit_Account extends Assets{
	private double apr;	
	private double balance;
	//deposit object holds: apr 
	public Deposit_Account(String code, String type, String label,double apr) {
		super(code,type,label);
		// TODO Auto-generated constructor stub
		this.apr = apr;
	}
	
	public Deposit_Account(Deposit_Account depositAccount) {
		this(depositAccount.getCode(), depositAccount.getType(), depositAccount.getLabel(), depositAccount.getAPR());
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
		
		return Math.pow(Math.E, getAPR()) - 1;
	}
	
	public double getValue() {
		return 0;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public double getQuartDiv() {
		return 0;
	}
	
	public double getCalcValue() {
		return getBalance();
	}
}
