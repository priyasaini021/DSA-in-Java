public class InversionCount {
    public static int mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return 0;
        }

        int mid = si + (ei - si) / 2;

        int count = mergeSort(arr, si, mid);
        count += mergeSort(arr, mid + 1, ei);
        count += merge(arr, si, mid, ei);

        return count;
    }

    public static int merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;
        int count = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[si + i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        System.out.println(
            mergeSort(arr, 0, arr.length - 1)
        );
    }
}

