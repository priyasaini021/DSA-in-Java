 import java.util.ArrayList;
public class MaxInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(45);
        list.add(23);
        list.add(67);
        list.add(34);

        int max = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("ArrayList: " + list);
        System.out.println("Maximum Element: " + max);
    }
}

