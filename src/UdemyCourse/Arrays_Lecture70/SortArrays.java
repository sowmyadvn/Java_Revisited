import java.util.Scanner;

public class SortArrays {
    public static void main(String[] args) {
    	SortArrays sortArr = new SortArrays();
    	int[] array = sortArr.getIntegers(8);
    	sortArr.printArray(array);
    	int[] result = sortArr.sortArray(array);
    	sortArr.printArray(result);
    }

    public int[] getIntegers(int n) {
    	int[] array = new int[n];
    	System.out.println("Enter "+n+" elements");
    	Scanner scanner = new Scanner(System.in);
    	for(int i= 0; i < n; i++) {
    		array[i] = (i+1)*5;
    	}

    	return array;
    }
    public void printArray(int[] array) {
    	System.out.println();
    	for(int i = 0; i < array.length; i++ ) {
    		System.out.print(array[i]+" ");
    	}
    }
    public int[] sortArray(int[] array) {
    	return sortArray(array,0,array.length-1);
    }

    public int[] sortArray(int[] array, int low, int high) {
    	int mid = (low+high)/2;
    	int[] result = new int[array.length];
    	if( low < high) {
    		sortArray(array, low, mid);
    		sortArray(array,mid+1,high);
	    	result = merge(array,low,mid,high);
	    }
	    return result;
    }

    public int[] merge(int[] array, int low, int mid, int high) {
    	int[] subArray1 = new int[mid-low+1];
    	int[] subArray2 = new int[high-mid];
    	int[] result = new int[array.length];

    	for(int i = 0; i < mid-low+1; i++) {
    		subArray1[i] = array[i];
    	}

    	for(int i = 0; i < high-mid; i++) {
    		subArray2[i] = array[mid+1+i];
    	}
    	int p1 = 0, p2 = 0,p3 = 0;
		while(p1 < subArray1.length && p2 < subArray2.length) {
			if(subArray1[p1] > subArray2[p2]) {
				result[p3] = subArray1[p1];
				p1++;
				p3++;
			}
			else {
				result[p3] = subArray2[p2];
				p2++;
				p3++;
			}
    	}

    	while( p1 < subArray1.length) {
    		result[p3] = subArray1[p1];
			p1++;
			p3++;
    	} 

    	while( p2 < subArray2.length) {
    		result[p3] = subArray2[p2];
			p2++;
			p3++;
    	}

    	return result;
    }
}
