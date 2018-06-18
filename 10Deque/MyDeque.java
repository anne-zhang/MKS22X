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
		start = 0;
		end = 0;
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
		if (element == null) {
            throw new NullPointerException();
        }
        if (start == end) {
            resize();
        }
        start--;
        if (start < 0) {
            start+= data.length;
        }
        data[start] = element;
        size++;	
    }

    public void addLast(E element){
		
	     if(element == null){
	        throw new NullPointerException();
	       }
      if(size == data.length || start - 1 == end) {
  	         resize();
  	     }
      if(size == 0){
        data[end] = element;
      }
      else if(end == data.length - 1){
           data[0] = element;
           end = 0;
         }
       else{
         data[end + 1] = element;
	        end++;
        }
        size+= 1;
    }
    
    public E removeFirst(){
		if (size() == 0){
	    	throw new NoSuchElementException();
		}
		E element = data[start];
		data[start] = null;
		start ++;
		if (start >= data.length) {
            start -= data.length;
        }
        size--;
		return element;
	
    }

    public E removeLast(){
    	E ans = data[end];
		if (start == end) {
            throw new NoSuchElementException();
        }
        end--;
        data[end] = null;
        if (end < 0) {
            end += data.length;
        }
        size--;
        return ans;

    }

    public E getFirst(){
		return data[start];
    }

    public E getLast(){
    	int i = end --;
    	if (i < 0){
    		i += data.length;
    	}
		return data[i];
    }
    
    public String toString() {
        String string = "[";
        for (E element : data) {
            string += element + ",";
        }
        return string.substring(0, string.length()-1) + "]";
    }

    public static void main(String[] args) {
        MyDeque<Integer> a = new MyDeque<Integer>(2);

        int[] nums = {0,1,2,3,4};

        for (Integer num : nums) {
            a.addFirst(num);
            a.addLast(num);
            System.out.println(a);
        }
        a.addFirst(10);
        System.out.println(a);
    }
    

}
