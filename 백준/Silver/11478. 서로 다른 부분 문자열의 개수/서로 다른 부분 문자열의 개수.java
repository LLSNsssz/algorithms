import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        // 모든 부분 문자열을 저장할 HashSet
        HashSet<String> substrings = new HashSet<>();
        
        // 모든 가능한 부분 문자열 생성
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        
        // 서로 다른 부분 문자열의 개수 출력
        System.out.println(substrings.size());
    }
}