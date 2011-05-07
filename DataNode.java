
//@ public invariant value != null;
public class DataNode extends Node{
	Object value;

	//@ requires value != null;
  public DataNode(Object value) {
		super();
		this.value = value;
	}
}
