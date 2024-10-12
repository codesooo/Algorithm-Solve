import java.util.*;
class Pair {
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static Pair left = new Pair(3,0);
    static Pair right = new Pair(3,2);
    static Pair[] phones = new Pair[10];
    static int[][] map = new int[4][3];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        
        // phones 배열 값 채우기
        inputPhones();
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                left.x = phones[numbers[i]].x;
                left.y = phones[numbers[i]].y;
                answer.append("L");
                System.out.println("L");
                continue;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right.x = phones[numbers[i]].x;
                right.y = phones[numbers[i]].y;
                System.out.println("R");
                answer.append("R");
                continue;
            }
            
            int right_dis = bfs(right.x, right.y, numbers[i]);
            System.out.println("=================");
            int left_dis = bfs(left.x, left.y, numbers[i]);
            System.out.println("=================");
            System.out.println("right_dis : " + right_dis + ", left_dis : " + left_dis);
            
            int move = -1;
            // move = -1 이면 왼쪽, 1이면 오른쪽
            if(right_dis == left_dis){
                if(hand.equals("right")){
                    move = 1;
                }
            }
            else if(right_dis < left_dis){
                move = 1;
            }
            
            if(move < 0){
                left.x = phones[numbers[i]].x;
                left.y = phones[numbers[i]].y;
                answer.append("L");
                System.out.println("L");
            } else{
                right.x = phones[numbers[i]].x;
                right.y = phones[numbers[i]].y;
                answer.append("R");            
                System.out.println("R");
            }
        }
        
        return answer.toString();
    }
    
    private int bfs(int x, int y, int num){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[4][3];
        int[][] distance = new int[4][3];
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int p=0; p<4; p++){
                int nx = now[0] + dx[p];
                int ny = now[1] + dy[p];
                
                if(nx<0 || ny <0 || nx>=4 || ny >= 3 || visited[nx][ny]){
                    continue;
                }
                
                distance[nx][ny] = distance[now[0]][now[1]] + 1;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                System.out.println("좌표 : " + nx + ", " + ny);
                System.out.println("거리 : " + distance[nx][ny]);
                
                if(map[nx][ny] == num){
                    System.out.println("동일 : " + map[nx][ny] + ",  " + num);
                    return distance[nx][ny];
                    
                }
                
                
            }
        }
        return 0;
    }
    
    private void inputPhones(){
        phones[0] = new Pair(3, 1);
        phones[1] = new Pair(0, 0);
        phones[2] = new Pair(0, 1);
        phones[3] = new Pair(0, 2);
        phones[4] = new Pair(1, 0);
        phones[5] = new Pair(1, 1);
        phones[6] = new Pair(1, 2);
        phones[7] = new Pair(2, 0);
        phones[8] = new Pair(2, 1);
        phones[9] = new Pair(2, 2);
        
        int num = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map[i][j] = num;
                num++;
            }
        }
        map[3][0] = -1;
        map[3][1] = 0;
        map[3][2] = -1;
    }
}