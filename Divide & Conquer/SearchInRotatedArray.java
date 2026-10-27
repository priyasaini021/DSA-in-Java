public class SearchInRotatedArray {
  public static int search(int[] arr, int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // Left half is sorted
        if (arr[si] <= arr[mid]) {
            if (target >= arr[si] && target < arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        }

        // Right half is sorted
        if (target > arr[mid] && target <= arr[ei]) {
            return search(arr, target, mid + 1, ei);
        }

        return search(arr, target, si, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(
            search(arr, target, 0, arr.length - 1)
        );
    }
}

