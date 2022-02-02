import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<=len;i++){ // h의 범위는 0부터 length까지
            int cnt = 0;
            boolean flag = false;
            for(int j=len-1;j>=0;j--){ // 뒤에서부터 
                if(citations[j] >= i) {
                    if(++cnt >= i) { // H-Index를 만족하면
                        flag = true;
                        answer = i; // 최대의 h로 갱신
                        break;
                    }
                }
            }
            if(!flag){ // 최대를 넘으면 for문 나오기
                break;
            }
        }
        return answer;
    }
}
