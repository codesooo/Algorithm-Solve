import java.io.*;
import java.util.*;
public class Main {

    static int N;
    static int[][] score;
    static ArrayList<Integer> teamA;
    static ArrayList<Integer> teamB;
    static int minscore;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        score = new int[N + 1][N + 1];
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();
        minscore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1,N/2);
        System.out.println(minscore);
    }
    public static void solution(int idx, int teamNum){

        if(teamNum == 0){
            for(int i=1; i<=N; i++){
                if(!teamA.contains(i)){
                    teamB.add(i);
                }
            }
            checkScore();
            teamB.clear();
            return;
        }

        for(int i=idx; i<=N; i++){
            teamA.add(i);
            solution(i+1, teamNum-1);
            teamA.remove(teamA.size() - 1);
        }
    }
    public static void checkScore(){
        int teamA_score = 0;
        int teamB_score = 0;
        for(int i=0; i<N/2-1 ; i++){
            for(int j=i+1; j<N/2; j++){
                int teamA_1 = teamA.get(i);
                int teamA_2 = teamA.get(j);
                teamA_score += score[teamA_1][teamA_2] + score[teamA_2][teamA_1];

                int teamB_1 = teamB.get(i);
                int teamB_2 = teamB.get(j);
                teamB_score += score[teamB_1][teamB_2] + score[teamB_2][teamB_1];
            }
        }
        int scoreSub = Math.abs(teamA_score - teamB_score);
        minscore = Math.min(minscore, scoreSub);
    }
}
