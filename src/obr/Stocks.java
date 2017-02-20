package obr;

public class Stocks extends Assets{
	private double quartDiv;
	private double baseRateOfReturn;
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	

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
	
	public double getValue() {
		return sharePrice;
	}
	
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
}
