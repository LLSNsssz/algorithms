import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    LinkedList<Integer> integers = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      integers.add(i);
    }

    int index = 0;
    ArrayList<Integer> list = new ArrayList<>();
    while (!integers.isEmpty()) {
      index = (index + K - 1) % integers.size();
      list.add(integers.remove(index));
    }

    bw.write(String.valueOf(list).replace("[", "<").replace("]",">"));
    bw.flush();
    bw.close();
    br.close();
  }
}
