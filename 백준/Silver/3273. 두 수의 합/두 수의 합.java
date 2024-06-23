import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());
    boolean[] flag = new boolean[1000001];

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (x > arr[i] && x - arr[i] <= 1000000 && flag[x - arr[i]]){
            count++;
        }
      flag[arr[i]] = true;
    }

    bw.write(String.valueOf(count));
    br.close();
    bw.flush();
    bw.close();
  }
}