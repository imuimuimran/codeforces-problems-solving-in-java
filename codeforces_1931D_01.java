import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_1931D_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int count = countPairs(arr, x, y);
            System.out.println(count);
        }

        scanner.close();
    }

    public static int countPairs(int[] arr, int x, int y) {
        Map<Integer, Integer> modX = new HashMap<>();
        Map<Integer, Integer> modY = new HashMap<>();
        
        int count = 0;

        for (int n : arr) {
            int remX = n % x;
            int remY = n % y;
            modX.put(remX, modX.getOrDefault(remX, 0) + 1);
            modY.put(remY, modY.getOrDefault(remY, 0) + 1);
        }

        for (int n : arr) {
            int remX = n % x;
            int remY = n % y;

            int compRemX = (x - remX) % x; // Ensure non-negative value
            int compRemY = (y - remY) % y; // Ensure non-negative value

            // Count pairs where the sum is divisible by x and difference is divisible by y
            count += modX.getOrDefault(compRemX, 0) * modY.getOrDefault(compRemY, 0);
            
            // If the number itself satisfies both conditions, decrement count
            if ((n + n) % x == 0 && (n - n) % y == 0) {
                count--;
            }
        }

        return count/2;
    }
}
