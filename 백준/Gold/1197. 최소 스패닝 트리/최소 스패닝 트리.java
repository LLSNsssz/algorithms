import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, end, weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(start, end, weight));
        }

        int result = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.start, edge.end)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[y] = x;
        return true;
    }
}