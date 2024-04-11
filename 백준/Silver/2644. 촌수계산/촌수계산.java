import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer=-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        DFS(a, b, 0);
        System.out.println(answer);
    }

    public static void DFS(int start, int end, int cnt) {
        if (start == end) {
            answer = cnt;
            return;
        }
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (!visited[next]) {
                DFS(next, end, cnt + 1);
            }
        }


    }
}
