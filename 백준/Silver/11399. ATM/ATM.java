import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순 정렬
        Arrays.sort(times);
        
        // 각 사람이 기다리는 시간의 합 계산
        int total = 0;
        int accumulated = 0;
        
        for(int time : times) {
            accumulated += time;  // 현재 사람이 걸리는 시간 추가
            total += accumulated; // 총 대기시간에 누적
        }
        
        System.out.println(total);
    }
}