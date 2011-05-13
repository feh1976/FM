public class DataNode extends Node{
	
	//@ public invariant value != null;
	//@ public invariant next != null;
	Object value;
	private Node next;

  //@ requires value != null;
  //@ requires next != null;
  public DataNode(Object value, Node next) {
		this.value = value;
		this.next = next;
	}
  

	public Node getNext(){
		return next;
	}
	
	//@ requires next != null;
	//@ ensures this.next == next;
	public void setNext(Node next){
		this.next = next; 
	}
}
