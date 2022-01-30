import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int possibleWeight = weight;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){ // 트럭의 수만큼
            int nowWeight = truck_weights[i];
            while(true){
                if(possibleWeight >= nowWeight && q.size() < bridge_length){ // 트럭을 다리에 놓을 때
                    q.offer(nowWeight);
                    possibleWeight -= nowWeight;
                    answer++;
                    break;
                }
                // 트럭을 다리에 놓을 때까지 반복한다. - while문의 필요 이유
                if(q.size() == bridge_length){ // 다리가 꽉차면 하나씩 빼기 - ** 시간이 경과되지 않음.
                    possibleWeight += q.poll(); 
                }else if(possibleWeight < nowWeight && q.size() < bridge_length){ // 무게가 안될때 다리 위 이동
                    q.offer(0);
                    answer++;
                }
            }
        }
        // for문이 끝나면 모든 트럭이 다리 위에 올라와있으며, 제일 마지막에 마지막 트럭이 있을 것이므로
        answer += bridge_length; // 마지막 트럭까지 다리를 건너기 위해서는 다리 길이 만큼의 시간이 필요하다.
        return answer;
    }
    
}
