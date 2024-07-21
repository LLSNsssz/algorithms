import java.util.Scanner;

class Main {
    private static int[] counts = new int[3]; // -1, 0, 1의 개수를 저장할 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[][] paper = new int[N][N];
        
        // 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }
        
        countPapers(paper, 0, 0, N);
        
        // 결과 출력
        for (int count : counts) {
            System.out.println(count);
        }
        
        scanner.close();
    }
    
    private static void countPapers(int[][] paper, int x, int y, int n) {
        if (isSame(paper, x, y, n)) {
            counts[paper[x][y] + 1]++;
        } else {
            int newN = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    countPapers(paper, x + i * newN, y + j * newN, newN);
                }
            }
        }
    }
    
    private static boolean isSame(int[][] paper, int x, int y, int n) {
        int first = paper[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}