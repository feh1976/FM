
public class StartNode extends Node{

	//@ public invariant next != null;
	Node next;
	
	//@ requires next != null;
	public StartNode(Node next) {
		this.next = next;
	}
  
}
