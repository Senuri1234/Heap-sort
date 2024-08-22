
public class Heap_sort {

	

	    // Main method to sort an array
	    public void sort(int arr[]) {
	        int n = arr.length;

	        // Build heap (max-heap) from the input array
	        for (int i = 1; i < n; i++) {
	            // Shift up the element to restore the heap property
	            int current = i;
	            while (current > 0) {
	                int parent = (current - 1) / 2;
	                if (arr[current] > arr[parent]) {
	                    int temp = arr[current];
	                    arr[current] = arr[parent];
	                    arr[parent] = temp;
	                }
	                current = parent;
	            }
	        }

	        // Extract elements from the heap one by one
	        for (int i = n - 1; i > 0; i--) {
	            // Move the current root to the end of the array
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	            // Call heapify on the reduced heap
	            heapify(arr, i, 0);
	        }
	    }

	    // To heapify a subtree rooted at node i with size n
	    void heapify(int arr[], int n, int i) {
	        int largest = i; // Initialize largest as root
	        int left = 2 * i + 1; // left child
	        int right = 2 * i + 2; // right child

	        // If left child is larger than root
	        if (left < n && arr[left] > arr[largest]) {
	            largest = left;
	        }

	        // If right child is larger than the largest so far
	        if (right < n && arr[right] > arr[largest]) {
	            largest = right;
	        }

	        // If largest is not root
	        if (largest != i) {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;

	            // Recursively heapify the affected subtree
	            heapify(arr, n, largest);
	        }
	    }

	    // Method to print the array
	    public static void printArray(int arr[]) {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }

	    // Main method to test the algorithm
	    public static void main(String args[]) {
	        int arr[] = {4, 10, 3, 5, 1};

	        Heap_sort heapSort = new Heap_sort();
	        heapSort.sort(arr);

	        System.out.println("Sorted array is:");
	        printArray(arr);
	    }
	}


