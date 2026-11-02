 import java.util.Stack;

public class StockSpanProblem {

    public static void calculateSpan(int[] prices) {
        int n = prices.length;

        int[] span = new int[n];

        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);

        for (int i = 1; i < n; i++) {

            while (!s.isEmpty() &&
                   prices[s.peek()] <= prices[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }

            s.push(i);
        }

        for (int value : span) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 85, 100};

        calculateSpan(prices);
    }
}

