import java.util.*;
public class MyHeap <T extends Comparable<T>> {
    private int length;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	if (b){
	    isMax = true;
	}
	else{
	    isMax = false;
	}
	data = (T[])new Comparable[10];
	length = 0;
    }

    public int size(){
	return length;
    }

    public T peek(){
	return data[0];
    }

    public void add(T s){
		if (size() == data.length){
	    	resize();
		}
		data[size()] = s;
		pushUp(size());
		length++;
    }

    private void pushUp(int pos){
	if ((isMax && data[pos].compareTo(data[(int)((pos - 1) / 2)]) > 0) ||
	    (!isMax && data[pos].compareTo(data[(int)((pos - 1) / 2)]) < 0)){
	    T temp = data[pos];
	    data[pos] = data[(int)((pos - 1) / 2)];
	    data[(int)((pos - 1) / 2)] = temp;
	    pushUp((int)((pos - 1) / 2));
	}
    }
     public void pushDown(int index){
	int left= index*2+1;
	int right= index*2+2;
	if (isMax && left< size()&& data[index].compareTo(data[left]) < 0 && (right>= size() || data[right].compareTo(data[left]) <= 0) ||
	    !isMax && left< size()&& data[index].compareTo(data[left]) > 0 && (right>= size() || data[right].compareTo(data[left]) >= 0)
	    ){
	    //System.out.println("swapping " + data[index] + " and " + data[left]);
	    swap(index, left);	    
	    pushDown(left);
	   
	}

	else if (isMax && right< size() && data[index].compareTo(data[right]) < 0 && (left>= size() || data[left].compareTo(data[right]) <= 0) ||
		 !isMax && right< size()&& data[index].compareTo(data[right]) > 0 && (left>= size() || data[left].compareTo(data[right]) >= 0)
		 ){
	    //System.out.println("swapping " + data[index] + " and " + data[right]);
	    swap(index, right);
	    pushDown(right);			     	    
	}

    }


    public T remove(){
	T s = peek();
	swap(0, size()-1);
	length--;	
	pushDown(0);	
	return s;
    } 

    public void swap (int n, int m){
	T temp = data[n];
	data[n] = data[m];
	data[m] = temp;
    }

    
    public String toString(){
	String str= "";
	for(int i = 0; i < size(); i++){
	    str += data[i] + "  ";
	}
	return str;
    }
    

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Comparable[2*size()];
	for(int i = 0; i < size(); i++){
	    temp[i] = data[i];
	}
        data = temp;	
    }
    
    /*public static void main(String[] args) {
    MyHeap<String> a = new MyHeap<>(false);
    String[] b = new String[20];
    for(int i = 0; i < 20; i++){
      int temp = (int)(Math.random() * 26) + 97;
      char value = (char)temp;
      a.add("" + value);
      b[i] = "" + value;
    }

    Arrays.sort(b);

    System.out.println("MyHeap: " + a);
    System.out.println("Arrays: "+ Arrays.toString(b));

    boolean isCorrect = true;
    for(int i = 0; i < 20; i++){
      String temp = a.remove();
      if(!(temp.equals(b[i]))){
        System.out.println("there is an error");
        System.out.println(temp);
        System.out.println(b[i]);
        System.out.println(a);
        isCorrect = false;
      }
    }

    if(isCorrect){
      System.out.println("Yourightheap is correct!");
    }
    else{
      System.out.println("There are error(s)");
    }

  }*/

   
}
