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

    String string = br.readLine();
    int result = calculateBracketValue(string);

    bw.write(String.valueOf(result));
    br.close();
    bw.flush();
    bw.close();
  }

  public static int calculateBracketValue(String s) {
    Stack<Object> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[') { // 여는 괄호는 그대로 스택에 push
        stack.push(c);
      } else if (c == ')') {
        int value = 0;
        // 스택에서 정수들을 모두 pop하여 합산
        while (!stack.isEmpty() && stack.peek() instanceof Integer) {
          value += (Integer) stack.pop();
        }
        // 짝이 맞는 여는 괄호가 아니면 0 반환
        if (stack.isEmpty() || !stack.peek().equals('(')) {
          return 0;
        }
        stack.pop(); // 여는 괄호 제거
        stack.push(value == 0 ? 2 : value * 2); // 0이면 괄호안에 다른값이 있으므로 2, 아니면 value * 2
      } else if (c == ']') {
        int value = 0;
        // 스택에서 정수들을 모두 pop하여 합산
        while (!stack.isEmpty() && stack.peek() instanceof Integer) {
          value += (Integer) stack.pop();
        }
        // 짝이 맞는 여는 괄호가 아니면 0 반환
        if (stack.isEmpty() || !stack.peek().equals('[')) {
          return 0;
        }
        stack.pop(); // 여는 괄호 제거
        stack.push(value == 0 ? 3 : value * 3);// 0이면 3, 아니면 value * 3
      }
    }

    int result = 0;
    while (!stack.isEmpty()) {
      if (stack.peek() instanceof Integer) {
        result += (Integer) stack.pop();
      } else {
        //스택에 문자가 남아 있다면 올바르지 않은 괄호
        return 0;
      }
    }

    return result;
  }
}