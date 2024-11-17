import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 사용 가능한 일수
            int P = Integer.parseInt(st.nextToken()); // 연속하는 일수
            int V = Integer.parseInt(st.nextToken()); // 휴가 일수
            
            // 종료 조건 검사
            if(L == 0 && P == 0 && V == 0) break;
            
            // 캠핑 가능한 일수 계산
            int result = (V / P) * L;     // 완전한 주기에 대한 캠핑 일수
            result += Math.min(L, V % P); // 남은 기간에 대한 캠핑 일수
            
            // 결과 저장
            sb.append("Case ").append(caseNum).append(": ").append(result).append("\n");
            caseNum++;
        }
        
        System.out.print(sb);
    }
}