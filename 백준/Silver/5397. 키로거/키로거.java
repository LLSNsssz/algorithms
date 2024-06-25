import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      LinkedList<Character> list = new LinkedList<>();
      ListIterator<Character> iter = list.listIterator();
      String input = br.readLine();
      for (char c : input.toCharArray()) {
        switch (c) {
          case '<':
            if (iter.hasPrevious()) iter.previous();
            break;
          case '>':
            if (iter.hasNext()) iter.next();
            break;
          case '-':
            if (iter.hasPrevious()){
              iter.previous();
              iter.remove();
            }
            break;
          default:
            iter.add(c);
            break;
        }
      }
      for (char c : list) {
        bw.write(c);
      }
        bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
