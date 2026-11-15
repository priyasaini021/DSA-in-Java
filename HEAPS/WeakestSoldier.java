  import java.util.*;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {

        int soldiers;
        int index;

        Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        public int compareTo(Row r) {

            if (this.soldiers == r.soldiers) {
                return this.index - r.index;
            }

            return this.soldiers - r.soldiers;
        }
    }

    public static void main(String[] args) {
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 1, 0, 0}
        };

        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {

            int count = 0;
            for (int j = 0; j < army[i].length; j++) {

                if (army[i][j] == 1) {
                    count++;
                }
            }

            pq.add(new Row(count, i));
        }

        System.out.println("Weakest Rows:");

        for (int i = 0; i < k; i++) {

            Row r = pq.remove();
            System.out.println("Row " + r.index);
        }
    }
}

