import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류
            
            // M개의 간선 정보 입력 (사용하지 않음)
            for(int i = 0; i < M; i++) {
                br.readLine();
            }
            
            // 연결 그래프에서 모든 정점을 방문하는 최소 간선의 수는 N-1
            sb.append(N-1).append('\n');
        }
        
        System.out.print(sb);
    }
}