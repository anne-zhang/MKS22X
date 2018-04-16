public class MyLinkedList {
	private Node first, last;
	private int length;
	
	public MyLinkedList() {
		first = null;
		last = null;
		length = 0;
	}
	
	public boolean add(Integer value) {
    	if (size == 0){
    		first = new Node(value);
		  last = first;
    	}
        else{
    	    Node newNode = new Node(value);
    	    newNode.setPrev(last);
    	    last.setNext(newNode);
    	    last = newNode;
	    }
	    size++;
        return true;
	}
	
	public int size() {
		return length;
	}
	
	public void clear() {
		first = null;
		last = first;
		length = 0;
	}
	
	public String toString() {
    	String str = "[";
    	Node current = first;
    	for (int i = 0; i < size; i++){
    	    str += current.getValue() + ",";
    	    current = current.getNext();
    	}
    	if (!str.equals("[")) str = str.substring(0,str.length()-1);
    	return str + "]";

	}
	
	public Integer get(int index) {
		return getNode(index).getValue();
	}
	
	public Integer set(int index, Integer newValue) {
	
	}
	
	public void add(int index, Integer value) {
	    if (index > size || index < 0) throw new IndexOutOfBoundsException();
	    if (index == size){
            add(value);
            return;
	    }
	    Node newNode = new Node(value);
    	if (index == 0){
    	    first.setPrev(newNode);
    	    newNode.setNext(first);
    	    first = newNode;
    	}
    	else{
    	    Node target = first;
    	    for (int i = 0; i < index; i++){
    		target = target.getNext();
    	    }
    	    newNode.setNext(target);
    	    target.getPrev().setNext(newNode);
    	    newNode.setPrev(target.getPrev());
    	    target.setPrev(newNode);
    	}
    	size++;
    }
	}
	
	public int indexOf(Integer value) {
	
	}
	
	public boolean remove(Integer value) {
	
	}
	
	public Integer remove(int index) {
	
	}
	
	public Node getNode(int index) {
		if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int x = 0; x < index; x++) {
            current = current.getNext();
        }
        return current;
    }
    
    private class Node {
    	private Node next, prev;
    	Integer data;
    	
		public Node(Integer value) {
            next = null;
            prev = null;
            data = value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public Integer getValue() {
            return data;
        }

        public String toString() {
            return ""+data;
        }

        public void setNext(Node nextNode) {
            next = nextNode;
        }

        public void setPrev(Node prevNode) {
            prev = prevNode;
        }

        public void setValue(Integer newValue) {
            data = newValue;
        }
    }
}