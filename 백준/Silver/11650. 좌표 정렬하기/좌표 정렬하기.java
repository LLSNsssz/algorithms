import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[N][2];
        
        // 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            coordinates[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }
        
        // 좌표 정렬
        Arrays.sort(coordinates, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // x좌표가 같으면 y좌표 기준으로 정렬
            }
            return a[0] - b[0]; // x좌표 기준으로 정렬
        });
        
        // 정렬된 좌표 출력
        for (int i = 0; i < N; i++) {
            bw.write(coordinates[i][0] + " " + coordinates[i][1] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}