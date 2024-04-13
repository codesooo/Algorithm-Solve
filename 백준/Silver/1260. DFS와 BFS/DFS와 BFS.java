import java.io.*;
import java.util.*;
public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static ArrayList<Integer> dfs_list;
    static ArrayList<Integer> bfs_list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N + 1];
        dfs_list = new ArrayList<>();
        bfs_list = new ArrayList<>();


        // list의 각 index 초기화
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        DFS(V);
        visited = new boolean[N+1];
        BFS(V);


        // 출력
        for (int i : dfs_list) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : bfs_list) {
            System.out.print(i + " ");
        }
    }

    public static void DFS(int start) {

        visited[start] = true;
        dfs_list.add(start);
        for (int i : list[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int start){
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            bfs_list.add(now);
            for (int i : list[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);

                }

            }
        }
    }
}
