import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        
        // 초밥 벨트 정보 입력
        int[] belt = new int[N];
        for(int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        
        // 초밥 가짓수 세기
        int[] eaten = new int[d+1];
        int count = 0;
        
        // 처음 k개의 접시 처리
        for(int i = 0; i < k; i++) {
            if(eaten[belt[i]] == 0) count++;
            eaten[belt[i]]++;
        }
        
        int max = count;
        
        // 한 칸씩 이동하며 확인
        for(int i = 0; i < N; i++) {
            // 이전 위치 초밥 제거
            eaten[belt[i]]--;
            if(eaten[belt[i]] == 0) count--;
            
            // 다음 위치 초밥 추가
            int next = (i + k) % N;
            if(eaten[belt[next]] == 0) count++;
            eaten[belt[next]]++;
            
            // 쿠폰 초밥 확인
            if(eaten[c] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }
        }
        
        System.out.println(max);
    }
}