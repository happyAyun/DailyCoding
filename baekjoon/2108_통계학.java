package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2108_통계학 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int sum = 0; // 산술 평균을 위한 총합
		int centerIdx = N / 2; // 중앙값을 위한 인덱스
		int[] cntt = new int[8001]; // 최빈값
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
			cntt[arr[i] + 4000]++;
		}
		Arrays.sort(arr);
		sb.append((int) Math.round((double) sum / N) + "\n"); // 반올림을 위해 double과 int형변환
		sb.append(arr[centerIdx] + "\n");
		boolean flag = true; // 두번째로 작은 값을 위해
		int mm = 0, num = 0;
		for (int i = 0; i < 8001; i++) {
			if (cntt[i] == 0) // 중요
				continue;
			if (mm < cntt[i]) {
				mm = cntt[i];
				num = i - 4000;
				flag = true; // ** 다시 새로운 값으로 갱신되면 그 수와 같은 2번째 작은 수를 구해야 하므로!!
			} else if (mm == cntt[i] && flag) {
				flag = false;
				num = i - 4000;
			}
		}
		sb.append(num + "\n");
		sb.append(arr[N - 1] - arr[0] + "\n"); // 범위
		System.out.println(sb);

	}

}
