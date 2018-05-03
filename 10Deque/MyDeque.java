import java.util.*;

public class MyDeque<E> {

    private int start;
    private int end;
    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public MyDeque(){
		data = (E[]) new Object[10];
		size = 0;
    	}

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){

		if (initialCapacity < 0){
	    	throw new IllegalArgumentException();
		}

		data = (E[]) new Object[initialCapacity];
		size = 0;
    }

    public int size(){
		return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
		E[] temp = (E[]) new Object[data.length * 2];
		for (int x = 0; x < data.length; x++){
	    	temp[x] = data[x];
		}
		data = temp;
		start = 0;
		end = size() - 1;
    }

    public void addFirst(E element){

		if (element == null){
	    	throw new NullPointerException();
		}
		if (size() == data.length || end == start - 1){
	    	resize();
		}
		if (start == 0){
	    	if (data[start] == null){
			data[start] = element;
	    	}
	    	else {
			data[data.length - 1] = element;
			start = data.length - 1;
	    	}
		}
		else {
	    	data[start - 1] = element;
	    	start = start - 1;
		}
		size = size + 1;
    }

    public void addLast(E element){

		if (element == null){
	    	throw new NullPointerException();
		}
		if (size() == data.length || start == end + 1 ||
	    	end == start + 1){
	    	resize();
		}
    	if (size() == 0) {
	    	data[0] = element;
	    	start = 0;
	    	end = 0;
		} 
		else if (end == data.length - 1) { 
	    	end = 0;
	    	data[end] = element;
		} 
		else { 
	    	end ++;
	    data[end] = element;
	}
        size ++;
    }
    
    public E removeFirst(){
		if (size() == 0){
	    	throw new NoSuchElementException();
		}
		E element = data[start];
		data[start] = null;
		start ++;
		return element;
	
    }

    public E removeLast(){
		E ans = data[end];
		if (size() == 0){
	    	throw new NoSuchElementException();
		}
		if (end == 0){
	    	end = data.length - 1;
		}
		else {
	    	end = end - 1;
		}
		size = size - 1;
		return ans;
    }

    public E getFirst(){
		if (size() == 0){
	    	throw new NoSuchElementException();
		}
		return data[start];
    }

    public E getLast(){
		if (size() == 0){
	    	throw new NoSuchElementException();
		}
		return data[end];
    }
    
    public String toString() {
        String result = "[";

        if (size == 0) {
            return result + "]";
        }

        else if (start <= end) {
            for (int x = start; x <= end; x++) {
		result += data[x] + ", ";
            }
        }

        else {
            for (int x = start; x < data.length; x++) {
		result += data[x] + ", ";
            }

            for (int x = 0; x <= end; x++) {
		result += data[x] + ", ";
            }
        }

        result = result.substring(0, result.length() - 2) + "]";
        return result;
    } 
    

}