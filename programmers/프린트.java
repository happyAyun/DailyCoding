import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            q.offer(new Node(i,priorities[i]));
        }
        int num = 0; // 순서 - 결과값
        while(!q.isEmpty()){
            Node now = q.poll();
            boolean flag = false;
            for(Node n : q){
               if(n.priority > now.priority){ // 높은 우선순위가 있다면
                   flag = true;
                   break;
               }
            }
            if(flag){ // 뒤로
                q.offer(now);
            }else{
                num++; // 이번 순서
                if(now.idx == location){
                    answer = num;
                    break;
                }
            }
        }
        return answer;
    }
    static class Node{
        int idx, priority;

        public Node(int idx, int priority){
            super();
            this.idx = idx;
            this.priority = priority;
        }
    }
}
