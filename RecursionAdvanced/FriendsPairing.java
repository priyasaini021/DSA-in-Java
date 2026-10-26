public class FriendsPairing {
    public static int countWays(int n) {

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        int single = countWays(n - 1);

        // Friend pairs with one of the remaining friends
        int paired = (n - 1) * countWays(n - 2);

        return single + paired;
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(countWays(n));
    }
}

