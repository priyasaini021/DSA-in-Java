 import java.util.*;

public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int idx;
        int distSq;

        Point(int x, int y, int idx) {

            this.x = x;
            this.y = y;
            this.idx = idx;

            distSq = x * x + y * y;
        }

        public int compareTo(Point p) {
            return Integer.compare(this.distSq, p.distSq);
        }
    }

    public static void main(String[] args) {
        int cars[][] = {
            {3, 3},
            {5, -1},
            {-2, 4}
        };

        int K = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < cars.length; i++) {

            pq.add(new Point(
                cars[i][0],
                cars[i][1],
                i
            ));
        }

        System.out.println("Nearest " + K + " Cars:");

        for (int i = 0; i < K && !pq.isEmpty(); i++) {

            Point p = pq.remove();

            System.out.println(
                "Car " + p.idx +
                " -> (" + p.x + ", " + p.y + ")"
            );
        }
    }
}

