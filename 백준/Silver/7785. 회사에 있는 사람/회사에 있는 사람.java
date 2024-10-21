import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Set<String> presentEmployees = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];
            
            if (action.equals("enter")) {
                presentEmployees.add(name);
            } else if (action.equals("leave")) {
                presentEmployees.remove(name);
            }
        }
        
        List<String> sortedEmployees = new ArrayList<>(presentEmployees);
        Collections.sort(sortedEmployees, Collections.reverseOrder());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String employee : sortedEmployees) {
            bw.write(employee + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}