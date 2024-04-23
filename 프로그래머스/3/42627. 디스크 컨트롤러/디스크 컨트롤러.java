import java.util.*;
class Solution {   
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;

        // 소요시간 우선순위 큐
        PriorityQueue<int[]> workQue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 작업 요청 시점 우선순위 큐
        PriorityQueue<int[]> inQue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int[] j : jobs) {
            inQue.offer(j);
        }

        while (!inQue.isEmpty() || !workQue.isEmpty()) {
            // 현재 시간에 수행 가능한 작업을 모두 '소요시간 우선순위 큐'에 넣음
            while (!inQue.isEmpty() && inQue.peek()[0] <= time) {
                workQue.offer(inQue.poll());
            }

            if (workQue.isEmpty()) {
                // '소요시간 우선순위 큐'가 비었다면, 현재 시간에 수행 가능한 작업이 없다는 의미
                // -> 현재 시간을 최소 요청 시간으로 변경
                time = inQue.peek()[0];
            } else {    // '소요시간 우선순위 큐'에서 작업시간이 가장 적은 것을 꺼내서 먼저 계산
                int[] j = workQue.poll();
                answer += time + j[1] - j[0];
                time += j[1];
            }
        }





        answer /= jobs.length;
        return answer;
    }
}