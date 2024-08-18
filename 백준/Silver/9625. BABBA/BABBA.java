import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        scanner.close();

        int A = 1, B = 0;

        for (int i = 0; i < K; i++) {
            int newB = A + B;
            int newA = B;
            A = newA;
            B = newB;
        }

        System.out.println(A + " " + B);
    }

}