import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()); // 우주의 개수
        int N = Integer.parseInt(st.nextToken()); // 행성의 개수
        
        int[][] universes = new int[M][N];
        int[][] ranks = new int[M][N];
        
        // 우주 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                universes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 각 우주별로 행성의 크기 순위로 변환
        for(int i = 0; i < M; i++) {
            TreeMap<Integer, Integer> rankMap = new TreeMap<>();
            for(int j = 0; j < N; j++) {
                rankMap.put(universes[i][j], 0);
            }
            
            int rank = 0;
            for(int key : rankMap.keySet()) {
                rankMap.put(key, rank++);
            }
            
            for(int j = 0; j < N; j++) {
                ranks[i][j] = rankMap.get(universes[i][j]);
            }
        }
        
        // 균등한 우주 쌍 찾기
        int count = 0;
        for(int i = 0; i < M-1; i++) {
            for(int j = i+1; j < M; j++) {
                boolean equal = true;
                for(int k = 0; k < N; k++) {
                    if(ranks[i][k] != ranks[j][k]) {
                        equal = false;
                        break;
                    }
                }
                if(equal) count++;
            }
        }
        
        System.out.println(count);
    }
}