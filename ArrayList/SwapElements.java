import java.util.ArrayList;
import java.util.Collections;

public class SwapElements {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Before Swap: " + list);

        Collections.swap(list, 1, 3);

        System.out.println("After Swap: " + list);
    }
}

