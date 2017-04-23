package obr;

import java.util.Comparator;


public class LinkedList <T> {
	private ListNode<T> head; //declare the head	
	private ListNode <T> tail; //declare the tail
	private ListNode <T> prevNode;
	private ListNode <T> afterNode;
	public void addElement(T element, Comparator<T> c) {
		
		if(getSize()==0){
			ListNode<T> newHead= new ListNode<T>(element);
			newHead.setNext(this.head);
			this.head=newHead;
		}
		else if (getSize()==1){
			int value=c.compare(element,head.getElement());
			if (value < 0){
				addToStart(element);
			}
			else if (value > 0){
				addToEnd(element);
			}
			else{
				addToEnd(element);
			}
		}
		else{
			int value=0;
			for(int i = 0; i <getSize(); i++) {
				prevNode=getListNode(i);
				afterNode= getListNode(i+1);
				value = c.compare(element,prevNode.getElement());
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
					}
				}
				else {
					ListNode <T> e = new ListNode<T>(element);
					prevNode.setNext(e);
					e.setNext(afterNode);
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
		for (int i=0; i< position-1; i++){
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
		this.getTail();
		if (this.tail!=null){
			ListNode<T> newTail=new ListNode<T> (t);
			this.tail.setNext(newTail);
			this.tail= newTail;
		}
		else{ //forces it to become an addToStartMethod
			this.addToStart(t);
		}
		//throw new UnsupportedOperationException("Not yet implemented.");
	}

	public void remove(int position) {
		ListNode<T> previousNode = this.getListNode(position-1);
		ListNode<T> afterNode=this.getListNode(position+1);
		previousNode.setNext(afterNode);
		
		//throw new UnsupportedOperationException("Not yet implemented.");
	}

}
