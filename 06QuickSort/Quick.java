import java.util.*;
public class Quick{
    public static int[] partition(int[] data, int start, int end){
		int p = (int) (Math.random()*(end-start) + start);
        int pivot = data[p];
        int low = start;
        int high = end;
        int i = start;
        while (i <= high) {
            if (data[i] == pivot) {
                i++;
            } else if (data[i] < pivot) {
                swap(data, i, low);
                low++;
                i++;
            } else {
                swap(data, i, high);
                high--;
            }
        }
        int[] ary = {low, high};
        return ary;
    }
   private static int[] swap(int[] a, int i, int j){
	int hold = a[i];
	a[i] = a[j];
	a[j] = hold;
	return a;
    }
  public static int quickselect(int[] data, int k) {
	if (k <= 0) {
	    k = 1;
	}
	return quickselect(data, k - 1, 0, data.length - 1);
    }

  private static int quickselect(int[] data, int k, int left, int right) {
	int[] partitionIndex = partition(data, left, right);
	if (partitionIndex[0] <= k && partitionIndex[1] >= k) {
	    return data[partitionIndex[0]];
	} else if (partitionIndex[0] > k) {
	    return quickselect(data, k, left, partitionIndex[0] - 1);
	} else if (partitionIndex[1] < k) {
	    return quickselect(data, k, partitionIndex[1] + 1, right);
	}
	return 0;
    }

  public static void quicksort(int[]ary){
	quicksortH(ary, 0, ary.length-1);
    }

  public static void quicksortH(int[]data, int lo, int hi){	
	if (lo < hi){
	    int[] bounds = partition(data, lo, hi);
	    quicksortH(data, lo, bounds[0]-1);
	    quicksortH(data, bounds[1]+1, hi);
	}
	
    }
}
