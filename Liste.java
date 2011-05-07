
//@ public invariant first != null;
//@ public invariant last != null;
//@ public invariant first != last;
//@ public invariant first.next != null;
//@ public invariant last.next == null;
//@ public invariant first.value == null;
//@ public invariant last.value == null;
//@ public invariant (\forall Node n; contain(n.value) && n != first && n != last ==> n.value != null);
//@ public invariant (\forall Node n; contain(n.value) ==> n.next != null);
//@ public invariant first.isEnd(last);
public class Liste {
	private Node first;
	private Node last;
	
	public Liste(){
		first = new Node();
		last = new Node();
		first.setNext(last);
	}
	
	//@ requires obj != null;
	//@ requires last != null;
  /*public void add(Object obj){
  	if (!contain(obj)){
  		Node temp = new Node();
  		if (temp != null){
    		last.value = obj;
    		last.next = temp;
  	  	//last = temp;
  		}
  	}
  }*/
  
  /*public void remove(Object obj){
  	
  }*/
  
	//@ requires obj != null;
  /*public boolean contain(Object obj){
  	return get(obj) != null;
  }*/
  
  //@ requires obj != null;
  //@ requires first != null;
  public Object get(Object obj){
  	Node n = first.getNext();
  	while (n != last){
  		if (n.value == obj)
  			return n;
  		n = n.next;
  	}
  	return null;
  }
}
