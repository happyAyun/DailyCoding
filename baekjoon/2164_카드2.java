package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> q = new LinkedList<>();
		// ** 만약 1이라면 바로 1을 출력 후 연산 끝.
		if (N == 1) {
			System.out.println(1);
			return;
		}
		// 우선 N까지 홀수는 버리고 짝수는 아래로 넣기위해 Queue에 넣는다.
		for (int i = 1; i <= N; i++) {
			if (i % 2 == 0) {
				q.offer(i);
			}
		}
		// ** N이 홀수이면 while의 반복을 가기 전 뒤로 넘겨주어야 함.
		// while은 짝수를 기준으로 버리기부터 진행하기 때문
		if (N % 2 != 0) {
			q.offer(q.poll());
		}
		// 마지막 하나의 카드가 남길 때까지
		while (q.size() > 1) {
			q.poll();
			if (q.size() == 1) // * 카드가 마지막 카드라면 break;
				break;
			else // 그렇지 않다면 다시 뒤로
				q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}
