import java.util.Scanner;

public class codeForces_1931D {
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
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % x == 0 && (arr[i] - arr[j]) % y == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
