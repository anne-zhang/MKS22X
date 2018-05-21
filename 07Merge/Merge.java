import java.util.Arrays;
public class Merge{

	public static void mergesort(int[] data){
		int[] temp = new int[data.length];
		msort(data, temp, 0, data.length - 1);
	}
	
	public static void msort(int[] data, int[] temp, int start, int end){
		if (start >= end){
			return ;
		}
			
			int mid = (start + end)/2;
			msort(data, temp, start, mid);
			msort(data, temp, mid + 1, end);
			merge(data, temp, start, mid, end);
		}
    public static void merge(int[] data, int[] temp, int start, int mid, int end){
		int newmid = mid+1;
		int count = start;
	

		while(start <= mid && newmid <= end){

	    	if (temp[start] <= temp[newmid]){
				data[count] = temp[start];
				start++;
	    	}
	    	else{
				data[count] = temp[newmid];
				newmid++;
	    	}
	    	count++;
		}

		while (start <= mid){
	    	data[count] = temp[start];
	    	start++;
	    	count++;
		}

		while (newmid <= end){
	    	data[count] = temp[newmid];
	    	newmid++;
	    	count++;
		}	

    }
	
	public static void insertionSort(int[] data, int start, int end) {
	for (int x = 0; x < data.length - 1; x++) {
	    for (int i = x + 1; i > 0; i--) {
		if (data[i] < data[i - 1]) {
		    int j = data[i];
		    data[i] = data[i - 1];
		    data[i - 1] = j;
		}
	    }
	}
    }
    
}