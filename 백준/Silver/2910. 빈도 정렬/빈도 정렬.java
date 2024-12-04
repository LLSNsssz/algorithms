import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> count = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : list) {
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}