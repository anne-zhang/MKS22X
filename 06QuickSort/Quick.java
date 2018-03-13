public class Quick{
    public int partition(int[] data, int start, int end){
		int pivot = (int)(Math.random()* data.length);
		swap(data,pivot,0);
		for (int i = 0; (i < data.length) && (start < end); i++){
	    	if(data[pivot] >= data[i]){
				swap(data,i,start);
				start++;
	    	}
	   		else{ 
	   		swap(data,i,end);
			end--;
			i--;
	   		}
		}
		swap(data,0,start);
		return start;
	
    	}

  public static void swap(int[] ary, int first, int second){
    int temp = ary[first];
    ary[first]=ary[second];
    ary[second]=temp;
}	
}
