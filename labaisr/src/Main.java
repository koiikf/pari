import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] A = new int[n + 1];
        int[] B = new int[n + 1];

        int count = 100000;

        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            A[i] = A[i - 1] + a;
            B[i] = B[i - 1] + b;
        }

        for (int i = 1; i <= n; i++) {
            count = Math.min(count, A[i] + B[n] - B[i] + t);
        }

        System.out.println(count);
    }
}
