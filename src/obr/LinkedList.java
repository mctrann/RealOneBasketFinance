package obr;

import java.util.Comparator;


public class LinkedList <T> {
	private ListNode<T> head; //declare the head	
	private ListNode <T> tail; //declare the tail
	private ListNode <T> prevNode;
	private ListNode <T> afterNode;
	public void addElement(T element, Comparator<T> c) {
		System.out.println(getSize());
		if(getSize()==0){
			ListNode<T> newHead= new ListNode<T>(element);
			newHead.setNext(this.head);
			this.head=newHead;
			System.out.println("head: " + head.getElement());
			System.out.println();
		}
		else if (getSize()==1){
			int value=c.compare(element,head.getElement());
			System.out.println("head: " + head.getElement());
			System.out.println("element: " + element);
			if (value < 0){
				addToStart(element);
				System.out.print("h");
				System.out.println();
			}
			else if (value > 0){
				ListNode<T> newTail= new ListNode<T>(element) ;
				this.tail= newTail;
				this.tail.setNext(null);
				head.setNext(this.tail);
				System.out.println("t");
				System.out.println();
			}
			else{
				ListNode<T> newTail= new ListNode<T>(element) ;
				this.tail= newTail;
				this.tail.setNext(null);
				head.setNext(this.tail);
				System.out.println("c");
				System.out.println();
			}
		}
		else{
			int value=0;
			for(int i = 0; i <getSize(); i++) {
	
				prevNode=getListNode(i);
				afterNode= getListNode(i+1);
				
				System.out.println("element: " + element);
				System.out.println("head: " + head.getElement());
				System.out.println("prevNode: " + prevNode.getElement());
				System.out.println("afterNode: " + afterNode.getElement());
				value = c.compare(element,prevNode.getElement());
				System.out.println();
				if(value < 0) {
					addToStart(element);
					break;
				}
				else if(value > 0) {
					value=c.compare(element,afterNode.getElement());
					if(value < 0){
						ListNode <T> e = new ListNode<T>(element);
						prevNode.setNext(e);
						e.setNext(afterNode);
						break;
					}
					else if(value == 0) {
						
//						if(i == getSize()-2) {
//							ListNode<T> newTail= new ListNode<T>(element) ;
//							this.tail= newTail;
//							afterNode.setNext(this.tail);
//							this.tail.setNext(null);
//							break;
//						}
//						else {
							ListNode<T> e = new ListNode<T>(element);
							e.setNext(afterNode.getNext());
							afterNode.setNext(e);
							break;
//						}
					}
					else if(value > 0) {
						if(i == getSize()-2) {
							ListNode<T> newTail= new ListNode<T>(element) ;
							this.tail= newTail;
							afterNode.setNext(this.tail);
							this.tail.setNext(null);
							break;
						}
					}
				}
				else {
					ListNode <T> e = new ListNode<T>(element);
					prevNode.setNext(e);
					e.setNext(afterNode);
					break;
				}
			}
		}
	}
	
	public int getSize() { 
		ListNode<T> current= head;
		int counter=0;
		while (current!=null){
			current=current.getNext();
			counter++; 
		}
		return counter;
		//throw new UnsupportedOperationException("Not yet implemented.");
	}
	
	public void clear() {
		head=null; //clears the head
		//throw new UnsupportedOperationException("Not yet implemented.");
	}
	
	private ListNode<T> getListNode(int position) {
		if (position <0 ||position > this.getSize()){
			throw new IllegalArgumentException("index out of bound");
		}
		ListNode<T> current= head;
		for (int i=0; i< position; i++){
			current= current.getNext();
		}
		return current;
		//throw new UnsupportedOperationException("Not yet implemented.");
	}
	
	public T getElement(int position) {
		ListNode<T> t= getListNode(position);
		T  p =  t.getElement();
		return p;
		//throw new UnsupportedOperationException("Not yet implemented.");    	
	}
	public void addToStart(T t) {
		ListNode<T> newHead=new ListNode<T> (t);
		newHead.setNext(this.head);
		this.head= newHead;

		//throw new UnsupportedOperationException("Not yet implemented.");
	}
	public void getTail(){
		this.tail=getListNode(this.getSize());
	}
	public void addToEnd(T t) {
		if(this.tail == null){
			ListNode<T> newTail= new ListNode<T>(t) ;
			this.tail= newTail;
			afterNode.setNext(this.tail);
			this.tail.setNext(null);
			
		}
		else if (this.tail!=null){
			ListNode<T> newTail=new ListNode<T> (t);
			this.tail.setNext(newTail);
			this.tail= newTail;
		}
//		else{ //forces it to become an addToStartMethod
//			this.addToStart(t);
//		}
		//throw new UnsupportedOperationException("Not yet implemented.");
	}

	public void remove(int position) {
		ListNode<T> previousNode = this.getListNode(position-1);
		ListNode<T> afterNode=this.getListNode(position+1);
		previousNode.setNext(afterNode);
		
		//throw new UnsupportedOperationException("Not yet implemented.");
	}

}
