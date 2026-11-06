import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {
            1, 2, 5, 10, 20, 50,
            100, 500, 2000
        };

        Arrays.sort(coins, Collections.reverseOrder());

        int amount = 590;
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int num = amount / coins[i];

                count += num;
                amount %= coins[i];
            }
        }

        System.out.println("Minimum Coins: " + count);
    }
}