import java.util.*;
import java.io.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] nearList;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        nearList = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++){
            nearList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            nearList[u].add(v);
            nearList[v].add(u);
        }
        
        int count = 0;
        
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    private static void DFS(int presentNode){
        if(visited[presentNode]){
            return;
        }
        else{
            visited[presentNode] = true;
            for(int i: nearList[presentNode]){
                if(!visited[i]){
                    DFS(i);
                }
            }
        }
    }

}