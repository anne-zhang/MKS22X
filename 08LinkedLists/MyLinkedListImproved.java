import java.util.*;
import java.util.Iterator;

public class MyLinkedListImproved<Type extends Comparable<Type>> implements Iterable<Type>{
	private Node first;
	private Node last;
	private int length;
	  
    private class Node {
    	private Node next, prev;
    	private Type data;
    	
		public Node(Type data, Node prev, Node next) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }
        

        public Type getValue() {
            return this.data;
        }

        public String toString() {
            return data + "";
        }

        public Node setNext(Node nextNode) {
            Node old = this.next;
	    	this.next = nextNode;
	    	return old;
        }

        public Node setPrev(Node prevNode) {
            Node old = this.prev;
	    	this.prev = prevNode;
	    	return old;

        }

        public Type setValue(Type newValue) {
            Type old = this.data;
	    	this.data = newValue;
	    	return old;

        }
    }
    
    private class ListIterator implements Iterator<Type>{
    	Node cur;
    	
    	public ListIterator(){
    		cur = first;
    	}
    	
    	public boolean hasNext(){
    		if(cur != null){
    			return true;
    		}
    		return false;
    	}
    	
    	public Type next(){
	    	if(hasNext()){
				Type ret= cur.getValue();
				cur = cur.getNext();
				return ret;
	    	}
	    	return null;
		}
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
    	
    	public MyLinkedListImproved(){
    		first = null;
			last = null;
			length = 0;
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
		
		public Type get(int n){
	if(n < 0 || n >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(n);
	return current.getValue();
    }
		
		public Type set(int index, Type value){ //Make sure of return type
			if(index < 0 || index >= size()){
	    		throw new IndexOutOfBoundsException();
			}
			Node current = getNode(index);
			current.setValue(value);
    	}
    	
    	public int indexOf(Type value) {
			for (int i = 0; i < length; i++){
	    		if(getNode(i).getValue().equals(value)){
				return i;
	    		}
			}
			return -1;
		}
		public boolean add(Type value) {
    		if (length == 0){
    			first = new Node(value, null, first);
		  		last = first;
    		}
        	else{
    	    	Node newNode = new Node(value, last, null);
    	    	newNode.setPrev(last);
    	    	last.setNext(newNode);
    	    	last = newNode;
	    	}
	    	length++;
        	return true;
		}
		public void add(int index, Type value) {
	    	if (index > length || index < 0) throw new IndexOutOfBoundsException();
	    	if (index == length){
            	add(value);
            	return;
	    	}
	    	Node newNode = new Node(value, null, first);
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
    	
    	public boolean remove(Type value){
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

    public Type remove(int index){
		if(index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
		}
		Type temp = get(index);
	
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
    public int max(){ 
	int maxIndex = 0;
	if(size() == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(Type n : this){
		if(n.compareTo(get(maxIndex)) > 0){
		    maxIndex = indexOf(n);
		}
	    }
	}
	return maxIndex;
    }

    public int min(){ 
	int minIndex = 0;
	if(size() == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(Type n : this){
		if(n.compareTo(get(minIndex)) < 0){
		    minIndex = indexOf(n);
		}
	    }
	}
	return minIndex;
    }

    public void extend(MyLinkedListImproved<Type> other){ 
	if(other.size() != 0){
	    if(size() != 0){
		last.setNext(other.first);
		other.getNode(0).setPrev(last);
		last = other.last;
		length = length + other.size();
	    }
	    else{
		first = other.first;
		last = other.last;
		length = length + other.size();
	    }
	}
	other.clear();
    }
    
    public static void main(String[] args){
     MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for(Integer x: a){
       System.out.print(x + " ");
     }

     System.out.println("\n" + a.max());
     System.out.println(a.min());

     MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
     b.add(5);
     b.add(2);
     b.add(100);
     a.extend(b);

     System.out.println(a);
     System.out.println(b);

     b.extend(a);
     System.out.println(a);
     System.out.println(b);

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }

	
}