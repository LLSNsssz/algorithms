import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 동전의 종류
        int K = sc.nextInt(); // 목표 금액
        
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
                count += K / coins[i];
                K %= coins[i];
            }
        }
        
        System.out.println(count);
        
        sc.close();
    }
}