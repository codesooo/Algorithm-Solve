import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> cowNums = new ArrayList<>();
        ArrayList<Stack<Integer>> CowLocs = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> Cows = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int cowLoc = Integer.parseInt(st.nextToken());

            if (!Cows.containsKey(cowNum)) {
                Cows.put(cowNum, new ArrayList<>(Arrays.asList(cowLoc)));
            } else {
                ArrayList<Integer> now = Cows.get(cowNum);
                if (now.get(now.size() - 1) != cowLoc) {
                    now.add(cowLoc);
                }
            }
        }

        int answer = 0;
        for (Integer key : Cows.keySet()) {
            if (Cows.get(key).size() > 1) {
                answer += Cows.get(key).size() - 1;
            }
        }

        System.out.println(answer);
    }

}
