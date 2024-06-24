import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(stA.nextToken());
    }
    Arrays.sort(a);

    int m = Integer.parseInt(br.readLine());
    StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      boolean find = false;
      int target = Integer.parseInt(stM.nextToken());
      int left = 0;
      int right = a.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (a[mid] > target) {
          right = mid - 1;
        } else if (a[mid] < target) {
          left = mid + 1;
        } else {
          find = true;
          break;
        }
      }
      bw.write(find ? "1" : "0");
      bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
  }
}