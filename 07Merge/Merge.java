public class Merge{

	public static void mergeSort(int[] data){
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}
	
	public static void mergeSort(int[] data, int[] temp, int start, int end){
		if (start < end){
			int mid = (start + end)/2;
			mergeSort(data, temp, start, mid);
			mergeSort(data, temp, mid + 1, end);
			merge( )
		}
	}
	public static void merge(){
	}
	
	public static void insertionSort(int[] data) {
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