 public class MaxHeap {
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void convertToMaxHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 3, 8, 6, 5, 7};

        convertToMaxHeap(arr, arr.length);

        System.out.println("Max Heap:");

        for (int x : arr)
            System.out.print(x + " ");
    }
}
