package obr;

public class Stocks extends Assets{
	private double quartDiv;
	private double baseRateOfReturn;
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	private double sharesOwned;

	//FIXME:constructor
	public Stocks (String code, String type, String label, double quartDiv, double baseRateOfReturn, double betaMeasure, String stockSymbol
			, double sharePrice) {
		// TODO Auto-generated constructor stub
		super(code,type, label);
		this.quartDiv=quartDiv;
		this.baseRateOfReturn=baseRateOfReturn;
		this.betaMeasure=betaMeasure;
		this.stockSymbol=stockSymbol;
		this.sharePrice=sharePrice;
		
	}
	
	public Stocks(Stocks aStock) {
		this(aStock.getCode(), aStock.getType(), aStock.getLabel(), aStock.getQuartDiv(), aStock.getBRR(), aStock.getRiskMeasure(), aStock.getStockSymbol(), aStock.getSharePrice());
	}
	
//TODO: MAKE GETTERS AND SETTERS FOR EACH

	public double getQuartDiv() {
		  return quartDiv;
	}
	
	public void setQuartDiv(double quartDiv) {
		  this.quartDiv = quartDiv;
	}
	
	public double getBRR() {
		  return baseRateOfReturn;
	}
	
	public void setbaseRateOfReturn(double baseRateOfReturn) {
		  this.baseRateOfReturn = baseRateOfReturn;
	}
	
	public double getRiskMeasure() {
		return betaMeasure;
	}
	
	public void setBetaMeasure(double betaMeasure) {
		this.betaMeasure = betaMeasure;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public double getSharePrice() {
		return sharePrice;
	}
	public double getSharesOwned() {
		return sharesOwned;
	}
	public void setSharesOwned(double sharesOwned) {
		this.sharesOwned = sharesOwned;
	}
	
	public double getCalcValue() {
		double totalValue = getSharePrice() * getSharesOwned();
		return totalValue;
	}
	
//	public double getAnnualReturn() {
//		
//	}
}
