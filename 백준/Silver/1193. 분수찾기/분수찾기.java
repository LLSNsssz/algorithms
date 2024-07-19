import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x = Integer.parseInt(br.readLine());
    br.close();

    int i = 1;
    while (x > i) {
      x -= i;
      i++;
    }

    int numerator = x;
    int denominator = i + 1 - x;
    if (i % 2 == 1) {
      int temp = numerator;
      numerator = denominator;
      denominator = temp;
    }

    bw.write(numerator + "/" + denominator);
    bw.flush();
    bw.close();
  }
}
