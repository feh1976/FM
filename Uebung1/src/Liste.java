public class Liste {

	// @ public invariant first != null;
	// @ public invariant last != null;
	// @ public invariant first.next != null;
	private StartNode first;
	private EndNode last;

	public Liste() {
		last = new EndNode();
		first = new StartNode(last);
	}

	// @ requires obj != null;
	public void add(Object obj) {
		if (!this.contain(obj)) {
			DataNode n = new DataNode(obj, this.last);
			this.getLast().setNext(n);
		}
	}

	// @ requires obj != null;
	public boolean remove(Object obj) {
		if (!this.contain(obj)) {
			Node n = this.first;
			while (n != this.last) {
				DataNode temp = (DataNode) ((DataNode) n).getNext();
				if (temp.value == obj) {
					((DataNode) n).setNext(temp.getNext());
					return true;
				} else
					n = temp;
			}
		}
		return false;
	}

	// @ requires obj != null;
	public boolean contain(Object obj) {
		return get(obj) != null;
	}

	// @ requires obj != null;
	public Object get(Object obj) {
		Node n = this.first.next;
		while (n != this.last) {
			if (((DataNode) n).value == obj)
				return n;
			n = ((DataNode) n).getNext();
		}
		return null;
	}

	public Object getItemAt(int index) {
		Node n = this.first;
		if (((DataNode) n).getNext() != this.last) {
			for (int i = 0; i <= index; i++) {
				n = ((DataNode) n).getNext();
			}
			return (DataNode) n;
		}
		return null;
	}

	private DataNode getLast() {
		Node n = this.first;
		while (((DataNode) n).getNext() != this.last)
			n = ((DataNode) n).getNext();
		return (DataNode) n;
	}

	public int size() {
		Node n = this.first;
		int size = 0;
		while (((DataNode) n).getNext() != this.last) {
			n = ((DataNode) n).getNext();
			size++;
		}
		return size;
	}
}
