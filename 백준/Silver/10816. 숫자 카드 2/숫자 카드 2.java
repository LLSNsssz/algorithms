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

    int N = Integer.parseInt(br.readLine());
    StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
    int[] arrN = new int[N];
    for (int i = 0; i < N; i++) {
      arrN[i] = Integer.parseInt(stN.nextToken());
    }
    Arrays.sort(arrN);

    int M = Integer.parseInt(br.readLine());
    StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(stM.nextToken());

      int count = upperBound(arrN, target) - lowerBound(arrN, target);
      bw.write(String.valueOf(count) + " ");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static int lowerBound(int[] arrN, int target) {
    int left = 0;
    int right = arrN.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arrN[mid] < target) {
        left = mid + 1;
      } else  {
        right = mid;
      }
    }
    return left;
  }
  private static int upperBound(int[] arrN, int target) {
    int left = 0;
    int right = arrN.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arrN[mid] <= target) {
        left = mid + 1;
      } else  {
        right = mid;
      }
    }
    return left;
  }
}
