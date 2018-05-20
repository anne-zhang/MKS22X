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

   
}
