
public class Node {
 	private Node next = null;
 	
 	public Node getNext(){
 		return next;
 	}
 	
 	//@ requires next != null;
 	//@ ensures this.next == next;
 	public void setNext(Node next){
 		this.next = next; 
 	}
 	
 	/*public isLast(Node n){
 		
 	}*/
}
