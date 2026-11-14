 import java.util.*;

public class RemoveFromHeap {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (x > 0 && arr.get(x) < arr.get(par)) {

                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() &&
                arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() &&
                arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {

                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {

            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }

            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            if (!arr.isEmpty()) {
                heapify(0);
            }

            return data;
        }

        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {

        Heap h = new Heap();

        h.add(40);
        h.add(20);
        h.add(30);
        h.add(10);

        System.out.println("Original Heap:");
        h.printHeap();

        System.out.println("Removed: " + h.remove());

        System.out.println("After Removal:");
        h.printHeap();
    }
}

