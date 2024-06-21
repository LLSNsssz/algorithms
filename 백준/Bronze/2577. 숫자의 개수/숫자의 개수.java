import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    br.close();

    String triple = String.valueOf(a * b * c);
    String[] chars = triple.split("");
    for (int i = 0; i < 10; i++) {
      int count = 0;
        for (String aStr : chars) {
            if (aStr.equals("" + i)) {
                count++;
            }
        }
      bw.write(count + "\n");
    }
    bw.flush();
    bw.close();
  }
}