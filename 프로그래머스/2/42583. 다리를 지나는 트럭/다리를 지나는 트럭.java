import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> waitedTrucks = new LinkedList<>();
        int time = 0;
        int completedWeightSum = 0, totalWeightedSum = 0;

        for(int i : truck_weights){
            waitedTrucks.offer(i);
            totalWeightedSum += i;
        }

        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }

        int movingWeightSum = 0;
        while(true){

            // 대기 중인 트럭이 없을 때
            if(waitedTrucks.size() == 0){
                if(completedWeightSum == totalWeightedSum){ // 다리 지나기 완료한 트럭 무게 총 합 == 트럭 무게 총 합
                    break;  // while문 종료
                }
                completedWeightSum += bridge.poll();
                time++;
                continue;
            }

            // temp = 다리 지나는 중인 트럭 무게 총 합 - 다리 지나기 완료할 트럭 무게 + 대기열을 빠져나올 트럭 무게
            int temp = movingWeightSum - bridge.peek() + waitedTrucks.peek();
            if(temp  <= weight){
                movingWeightSum -= bridge.peek();
                completedWeightSum += bridge.poll();

                bridge.add(waitedTrucks.peek());
                movingWeightSum += waitedTrucks.poll();
            } else {
                movingWeightSum -= bridge.peek();
                completedWeightSum += bridge.poll();
                bridge.add(0);
            }


            time++;
        }
        return time;
    }
}