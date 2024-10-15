import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static List<List<Integer>> result = new ArrayList<>();
    private static List[] arr;
    public static void main(String[] args) throws IOException {
        int ans = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] people = new int[N + 1];
        int peopleSum = 0;
        arr = new List[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            peopleSum += people[i];
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[i] = new LinkedList();
            for (int j = 0; j < n; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }


        for (int i = 1; i <= N / 2; i++) {
            combinations(i, 1, new ArrayList<>());
        }


        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }

        for (List<Integer> list : result) {
            int sum1 = 0, sum2 = 0, sub = 0;
            for (int i = 0; i < list.size(); i++) {
                sum1 += people[list.get(i)];
            }
            sum2 = peopleSum - sum1;

            sub = Math.abs(sum1 - sum2);

            ans = Math.min(sub, ans);

        }

        System.out.println(ans);
    }

    private static void combinations(int r, int start, List<Integer> current) {
        if (current.size() == r) {
            if (check(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            current.add(i);
            combinations(r, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    private static boolean check(List<Integer> list) {
        // 1. list의 것들이 인접한지 검사,
        // 2. list를 제외한 나머지 요소들이 인접한지 검사
        // 1, 2 둘 다 만족하면 true 반환
        // 둘 중 하나라도 만족하지 못하면 false 반환

        boolean[] visited = new boolean[N + 1];

        // 1. list의 구역들이 서로 연결되어 있는지 검사
        // list에서 첫 번째 구역을 기준으로, DFS 실행
        dfs(list.get(0), visited, list);

        // 모든 구역이 방문되었는지 확인
        for (int num : list) {
            if (!visited[num]) {
                return false;
            }
        }

        // 2. list에 포함되지 않은 나머지 구역들도 서로 연결되어 있는지 검사
        List<Integer> notInList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!list.contains(i)) {
                notInList.add(i);
            }
        }

        // 나머지 구역이 1개이면 그냥 true 반환
        if (notInList.size() == 1) {
            return true;
        }

        Arrays.fill(visited, false);
        dfs(notInList.get(0), visited, notInList);

        for (int num : notInList) {
            if (!visited[num]) {
                return false;
            }
        }


        return true;
    }

    private static void dfs(int node, boolean[] visited, List<Integer> group) {
        visited[node] = true;

        for (Object neighbor : arr[node]) {
            int next = (int) neighbor;
            if (!visited[next] && group.contains(next)) {
                dfs(next, visited, group);
            }

        }
    }
}
