import java.util.*;

public class mergeSort {

    public static int[] createRandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		Random random = new Random();
		for(int i = 0; i < arrayLength; i ++) {
			array[i] = random.nextInt(100);
		}
		return array;
	}

    public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}

    public static void bubbleSort(int[] array) {
        for(int i = array.length; i > 0; i --) {
            for(int j = 0; j < i-1; j ++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void mergeArray(int[] array, int start, int middle, int end) {
        int i = start;
        int j = middle;
        int k = 0;
        int[] tempArray = new int[end - start + 1];

        while(i < middle && j < end) {
            if(array[i] > array[j]) {
                tempArray[k] = array[j];
                j ++;
                k ++;
            } else {
                tempArray[k] = array[i];
                i ++;
                k ++;
            }
        }

        while(i < middle) {
            tempArray[k] = array[i];
            i ++;
            k ++;
        }

        while(j < end) {
            tempArray[k] = array[j];
            j ++;
            k ++;
        }

        for(i = start; i < end; i ++) {
            array[i] = tempArray[i - start];
        }
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                c[k] = a[i];
                k ++;
                i++;
            } else {
                c[k] = b[j];
                k ++;
                j ++;
            }
        }

        while(i < a.length) {
            c[k] = a[i];
            k ++;
            i ++;
        }

        while(j < b.length) {
            c[k] = b[j];
            k ++;
            j ++;
        }

        return c;
    }

    public static void mergeSortt(int[] a, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSortt(a, start, middle);
        mergeSortt(a, middle, end);
        mergeArray(a, start, middle, end);
    }
    
    public static void mergeSortt(int[] a) {
        mergeSortt(a, 0, a.length);
    }

    public static void displayText() {
        System.out.println("Comparing sorting methods");
        System.out.println("Sorting method one: Bubble Sort");
        System.out.println("Sorting method two: Merge sort");
    }

    public static void displayBubble(int[] array) {
        long start_time, time_spent;

        System.out.println("Bubble sort:");
        start_time = System.currentTimeMillis();
        System.out.println("Before sorting, isSorted(array): " + isSorted(array));
        bubbleSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Bubble sort time: " + time_spent + " ms");
        System.out.println("After sorting, isSorted(array): " + isSorted(array));
    }

    public static void displayMerge(int[] array) {
        long start_time, time_spent;

        System.out.println("Merge sort:");
        System.out.println("Before sorting, isSorted(array): " + isSorted(array));
        start_time = System.currentTimeMillis();
        mergeSortt(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Merge sort time: " + time_spent + " ms");
        System.out.println("After sorting, isSorted(array): " + isSorted(array));

    }

    public static void main(String[] args) throws Exception {
        
        displayText();
        System.out.println(" ");

        int arrayLength = 100_000;
        int[] array = createRandomArray(arrayLength);

        displayBubble(array);
        System.out.println(" ");

        arrayLength = 100_000;
        array = createRandomArray(arrayLength);

        displayMerge(array);

    }
}
