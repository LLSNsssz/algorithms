import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 이름->번호, 번호->이름을 위한 두 개의 자료구조
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        String[] numberToName = new String[N + 1];
        
        // 도감 정보 입력
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName[i] = name;
        }
        
        // 문제 해결
        for(int i = 0; i < M; i++) {
            String query = br.readLine();
            
            // 숫자인 경우
            if (Character.isDigit(query.charAt(0))) {
                int number = Integer.parseInt(query);
                sb.append(numberToName[number]);
            }
            // 문자인 경우
            else {
                sb.append(nameToNumber.get(query));
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}