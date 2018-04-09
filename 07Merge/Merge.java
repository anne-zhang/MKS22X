public class Merge{

	public static void mergeSort(int[] data){
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}
	
	public static void mergeSort(int[] data, int[] temp, int start, int end){
		if (start >= end){
			return ;
		}
		
		if (end - start <= 20){
			insertionSort(data, start, end);
		}
		
		else{
			for (int i = start; i <= end; i++){
				temp[i] = data[i];
			}
			
			int mid = (start + end)/2;
			mergeSort(data, temp, start, mid);
			mergeSort(data, temp, mid + 1, end);
			merge(data, temp, start, mid, end);
		}
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