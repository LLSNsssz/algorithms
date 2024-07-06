import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();

    Stack<Character> string1 = new Stack<>(); // ( 를 담을 스택
    Stack<Character> string2 = new Stack<>(); //  ) 를 담을 스택

    int count = 0;

    for (char c : str.toCharArray()) {
      if (c == '(') {
        while (!string2.isEmpty()) {
          string2.pop();
        }
        string1.push('(');
      }

      if (c == ')') {
        string1.pop();
        if (!string2.isEmpty()) {
          count++;
        } else {
          count += string1.size();
        }
        string2.push(')');
      }
    }

    bw.write(String.valueOf(count));

    br.close();
    bw.flush();
    bw.close();
  }
}
