package obr;


public class PortfolioList {
	private PortfolioListNode head=null; 
	private PortfolioListNode tail=null;
	
	//returns the size of the list
	public int getSize(){
		PortfolioListNode current = head;
		int count=0;
		while (current!=null){
			current=current.getNext();
			count++;
		}
		return count;
	}
	//empties list
	public void clear(){
		head=null; //clears the head
	}
	
	public void addToStart(Portfolios p){
		PortfolioListNode newHead= new PortfolioListNode(p);
		newHead.setNext(this.head);
		this.head=newHead;
	}
	public void getTail(){
	//FIXME:	this.tail=getPortfolioListNode(this.getSize());
	}
	public void addToEnd(Portfolios p) {
		this.getTail();
		if (this.tail!=null){
		PortfolioListNode newTail=new PortfolioListNode (p);
		this.tail.setNext(newTail);
		this.tail= newTail;
		}
		else{ //forces it to become an addToStartMethod
			this.addToStart(p);
		}
	}
		public void remove(int position) {
			PortfolioListNode previousNode = this.getPortfolioListNode(position-1);
			PortfolioListNode afterNode=this.getPortfolioListNode(position+1);
			previousNode.setNext(afterNode);
			
			//throw new UnsupportedOperationException("Not yet implemented.");
		}

		/**
		 * This is a private helper method that returns a {@link TruckListNode}
		 * corresponding to the given position.  Implementing this method
		 * is optional but may help you with other methods.
		 * @param position
		 * @return
		 */
		private PortfolioListNode getPortfolioListNode(int position) {
			if (position <0 ||position > this.getSize()){
				throw new IllegalArgumentException("index out of bound");
			}
			PortfolioListNode current= head;
			for (int i=0; i< position-1; i++){
				current= current.getNext();
			}
			return current;
			//throw new UnsupportedOperationException("Not yet implemented.");
		}

		/**
		 * Returns the {@link Truck} element stored at the given 
		 * <code>position</code>.
		 * @param position
		 * @return
		 */
		public Portfolios getPortfolio(int position) {
			PortfolioListNode p= getPortfolioListNode(position);
			Portfolios port = p.getPortfolio();
			return port;
			//throw new UnsupportedOperationException("Not yet implemented.");    	
		}

		/**
		 * Prints this list to the standard output.
		 */
		public void print() {
			StringBuilder sb= new StringBuilder();
			if (this.head==null){
				sb.append("[empty]");
			}
			else{
			for (int i=1; i<=this.getSize(); i++){
				PortfolioListNode p= getPortfolioListNode(i);
				Portfolios port= p.getPortfolio();
				sb.append(port.toString()+"\n");
				
			}
			}
			System.out.println(sb.toString());
			//throw new UnsupportedOperationException("Not yet implemented.");
		}
	}
	
	

