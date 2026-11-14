
    import java.util.*;

public class InsertInHeap {

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

        h.printHeap();
    }
}

