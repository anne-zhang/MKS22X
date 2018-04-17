public class MyLinkedList {
	private Node first, last;
	private int length;
	
	public MyLinkedList() {
		first = null;
		last = null;
		length = 0;
	}
	
	public boolean add(Integer value) {
    	if (length == 0){
    		first = new Node(value);
		  last = first;
    	}
        else{
    	    Node newNode = new Node(value);
    	    newNode.setPrev(last);
    	    last.setNext(newNode);
    	    last = newNode;
	    }
	    length++;
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
    	for (int i = 0; i < length; i++){
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
		Node current = getNode(index);
		int x = current.getValue();
		current.setValue(newValue);
		return x;
	}
	
	public void add(int index, Integer value) {
	    if (index > length || index < 0) throw new IndexOutOfBoundsException();
	    if (index == length){
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
    	length++;
    }
	
	public int indexOf(Integer value) {
		for (int i = 0; i < length; i++){
	    	if(getNode(i).getValue().equals(value)){
			return i;
	    	}
		}
		return -1;
	}
	
    public boolean remove(Integer value){
		int x = indexOf(value);
		if (x == -1){
	    	return false;
		}
		else if (x== 0){
	    	first = first.getNext();
	    	first.setPrev(null);
	    	length = length - 1;
		}
		else if(x== length - 1){
	    	last = last.getPrev();
	    	last.setNext(null);
	    	length = length - 1;
		}
		else{
	    	Node before = getNode(x - 1);
	    	Node after = getNode(x + 1);
	    	before.setNext(after);
	    	after.setPrev(before);
	    	length = length - 1;
		}
		return true;
    }

    public Integer remove(int index){
		if(index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
		}
		Integer temp = get(index);
	
		if(length == 1){
	    	first = null;
	    
	    	last = null;
		}
	
		else if(index == length - 1){
	    	last = getNode(length - 2);
	    
	    	last.setNext(null);
	    
		}
		else if(index == 0){
	    	first = getNode(1);
	    	first.setPrev(null);
		}
	
		else{
	    	Node tempP = getNode(index - 1);
	
	    	Node tempN = getNode(index + 1);
	    
	    	tempP.setNext(tempN);
	    	tempN.setPrev(tempP);
		}
		length--;
    
		return temp;
    }

	
	private Node getNode(int index) {
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