import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char value;
        Node left;
        Node right;
        
        Node(char value) {
            this.value = value;
        }
    }
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Node[] nodes = new Node[26];  // A-Z를 0-25 인덱스로 저장
        
        // 노드 생성
        for(int i = 0; i < N; i++) {
            nodes[i] = new Node((char)('A' + i));
        }
        
        // 트리 구성
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            if(left != '.') nodes[parent - 'A'].left = nodes[left - 'A'];
            if(right != '.') nodes[parent - 'A'].right = nodes[right - 'A'];
        }
        
        // 순회 실행
        preorder(nodes[0]);
        sb.append('\n');
        inorder(nodes[0]);
        sb.append('\n');
        postorder(nodes[0]);
        
        System.out.println(sb);
    }
    
    // 전위 순회: 루트 -> 왼쪽 -> 오른쪽
    static void preorder(Node node) {
        if(node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    
    // 중위 순회: 왼쪽 -> 루트 -> 오른쪽
    static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }
    
    // 후위 순회: 왼쪽 -> 오른쪽 -> 루트
    static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }
}