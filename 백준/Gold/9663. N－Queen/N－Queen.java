import java.util.Scanner;

/**
 * N-Queen 문제를 해결하는 클래스입니다.
 * 이 클래스는 백트래킹 알고리즘을 사용하여 N x N 체스판에 N개의 퀸을 서로 공격할 수 없게 배치하는 방법의 수를 계산합니다.
 */
public class Main {
    private static int n; // 체스판의 크기와 퀸의 개수
    private static int count; // 해결책의 개수

    /**
     * N-Queen 문제를 해결하고 결과를 출력합니다.
     *
     * @param args 명령줄 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        count = 0;
        int[] queens = new int[n];
        backtrack(queens, 0);
        System.out.println(count);
        scanner.close();
    }

    /**
     * 백트래킹 알고리즘을 사용하여 퀸을 배치합니다.
     *
     * @param queens 각 행에 있는 퀸의 열 위치를 저장하는 배열
     * @param row    현재 처리 중인 행
     */
    private static void backtrack(int[] queens, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, row + 1);
            }
        }
    }

    /**
     * 주어진 위치에 퀸을 놓을 수 있는지 확인합니다.
     *
     * @param queens 각 행에 있는 퀸의 열 위치를 저장하는 배열
     * @param row    확인할 행
     * @param col    확인할 열
     * @return 퀸을 놓을 수 있으면 true, 그렇지 않으면 false
     */
    private static boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || 
                Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}