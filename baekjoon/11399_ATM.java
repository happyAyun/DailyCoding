package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순 정렬 -> 최소의 시간
		int time = 0; // 총 시간 : 결과값
		int wait = 0; // 기다린 시간
		for (int i = 0; i < N; i++) {
			wait += arr[i];
			time += wait;
		}
		System.out.println(time);
	}
}
