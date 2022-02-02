import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int width = len-1; // 가로 방향으로 나아갔을 경우 최소의 이동
        for(int i=0;i<len;i++){
            // 상하 알파벳
            int c = name.charAt(i) - 'A';            
            answer += Math.min(c, 26-c);
            // 좌우 커서 이동
            int next = i+1; // 다음 인덱스
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            width = Math.min(width, i+len-next+Math.min(i,len-next)); // *** key-point
            // Math.min(i, len-next) 는 앞으로 갔다 다시 뒤로 넘어가는 경우와
            // 뒤에서부터 갔다 앞으로 다시 돌아오는 경우 중 최소를 구하는 방식이다.
        }
        return answer+width; 
    }
}
