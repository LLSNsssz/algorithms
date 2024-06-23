import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String roomNo = br.readLine();
    int[] count = new int[10];

    for (int i = 0; i < roomNo.length(); i++) {
      int num = roomNo.charAt(i) - '0';
        if (num == 9) {
          num = 6;
      }
        count[num]++;
    }

      count[6] = (count[6] + 1) / 2;

    int max = 0;
    for(int i = 0; i < count.length; i++) {
      max = Math.max(max, count[i]);
    }

    bw.write(String.valueOf(max));
    br.close();
    bw.flush();
    bw.close();
  }
}