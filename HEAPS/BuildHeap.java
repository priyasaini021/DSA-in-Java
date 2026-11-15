public class BuildHeap {

    static void heapify(int arr[], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, n, smallest);
        }
    }

    static void buildHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = {9, 4, 7, 1, 3, 6, 2};

        buildHeap(arr, arr.length);

        System.out.println("Min Heap:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
