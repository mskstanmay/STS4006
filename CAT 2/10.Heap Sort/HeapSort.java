public class HeapSort {

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.print("Input: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        heapSort(arr);

        System.out.print("Sorted: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
