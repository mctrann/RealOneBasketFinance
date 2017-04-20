package obr;
//creation of node
public class PortfolioListNode {
	private PortfolioListNode next;
	private Portfolios item;
	
	public PortfolioListNode (Portfolios item){
		this.item=item;
		this.next=null;
	}
	
	public Portfolios getPortfolio(){
		return item;
	}
	
	public PortfolioListNode getNext(){
		return next;
	}
	public void setNext(PortfolioListNode next){
		this.next=next;
	}
}
