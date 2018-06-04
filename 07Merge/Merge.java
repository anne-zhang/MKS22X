import java.util.Arrays;
public class Merge{

	public static void mergesort(int[] data){
		int[] temp = new int[data.length];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		msort(data, temp, 0, data.length - 1);
	}
	
	public static void msort(int[] data, int[] temp, int start, int end){
		if (end - start < 2){
			insertionSort(temp, start, end);
			return;
		}
			
			int mid = (start + end)/2;
			msort(temp, data, start, (start+end)/2);
			msort(data, temp, (start+end)/2+1, end);
			merge(data, temp, start, mid, end);
		}
    public static void merge(int[] data, int[] temp, int start, int mid, int end){
		int newmid = mid+1;
		int count = start;
	

		for (int i = start; i <= end; i++) {
			if (count > mid) {
				temp[i] = data[newmid];
				newmid+=1;
			}
			
			else if (newmid <= end) {

			    if (data[count] < data[newmid]) {
					temp[i] = data[count];
					count+=1;
			    }
			    else {
				temp[i] = data[newmid];
				newmid+=1;
			    }
			}
			
			else {
			    temp[i] = data[count];
			    count +=1;
			}

		}

		for (int i = start; i <= end; i++) {
			data[i] = temp[i];
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