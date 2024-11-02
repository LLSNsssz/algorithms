import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 집합 S를 HashSet으로 구현
        HashSet<String> set = new HashSet<>();
        
        // N개의 문자열을 집합에 추가
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        // M개의 문자열을 검사하여 집합 S에 포함된 개수를 카운트
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(count);
        
        br.close();
    }
}