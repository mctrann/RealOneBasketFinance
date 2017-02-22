package obr;

public class Deposit_Account extends Assets{
	
	//creates private variables of class Deposit_Account
	private double apr;	
	private double balance;
	
	//constructor
	public Deposit_Account(String code, String type, String label,double apr) {
		super(code,type,label);
		this.apr = apr;
	}
	
	//copy constructor
	public Deposit_Account(Deposit_Account depositAccount) {
		this(depositAccount.getCode(), depositAccount.getType(), depositAccount.getLabel(), depositAccount.getAPR());
	}
	
	//method to return APR
	public double getAPR() {
		return apr;
	}	

	//method to return risk measure
	public double getRiskMeasure() {
		return 0;
	}
	
	//TODO: USED?
	public double getValue() {
		return 0;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public double getBRR() {
		
		return Math.pow(Math.E, (getAPR()/100)) - 1;
=======
	//method to set the balance from the Portfolio.dat
=======
	//method to set the balance, used to set portfolio.dat value of deposits
>>>>>>> jjfield3
	public void setBalance(double balance) {
		this.balance = balance;
>>>>>>> jjfield3
	}
	
	//method to return the balance
	public double getBalance() {
		return balance;
	}
	
	//method to calculate the value
	public double getCalcValue() {
		return getBalance();
	}
	
	//method to calculate the annual return
	public double getAnnualReturn() {
		double apy = 0.0;
		apy = Math.pow(Math.E, getAPR()) - 1;
		return (apy * getBalance()) + getBalance();
	}
}
