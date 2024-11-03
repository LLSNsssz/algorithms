import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // HashMap을 사용하여 현재 회사에 있는 사람들을 추적
        HashSet<String> company = new HashSet<>();
        
        // 각 로그 처리
        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];
            
            if (action.equals("enter")) {
                company.add(name);
            } else { // leave
                company.remove(name);
            }
        }
        
        // 현재 회사에 있는 사람들을 리스트로 변환하고 정렬
        ArrayList<String> result = new ArrayList<>(company);
        Collections.sort(result, Collections.reverseOrder());
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String name : result) {
            sb.append(name).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}