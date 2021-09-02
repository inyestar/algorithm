package practice.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrintQueue {

	/**
	 * 현재 맨 앞의 원소보다 중요도가 높은 원소가 있을 경우 인쇄하지 않고 맨 뒤로 보낸다.
	 * First In, First Out
	 * (백준 : https://www.acmicpc.net/problem/1966)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int loop = scanner.nextInt(); // 문서의 개수
			for(int i=0; i<loop; i++) {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				
				List<int[]> queue = new ArrayList<>();
				int idx = 0;
				while(n > idx) {
					// 중요도와 처음 인덱스를 저장s
					queue.add(new int[] {idx++, scanner.nextInt()});
				}

				int cnt = 0; // 출력된 갯수
				while(true) {
					List<Integer> values = queue.stream().map(x -> x[1]).collect(Collectors.toList());
					int max = Collections.max(values);
					// 첫 번째 값이 제일 크면
					if (queue.get(0)[1] == max) {
						cnt++;
						if(queue.get(0)[0] == m) {
							System.out.println(cnt);
							break;
						} else {
							queue.remove(0);
						}
					} else {
						int[] tmp = queue.get(0);
						queue.add(tmp);
						queue.remove(0);
					}
				}
			}
		}

	}

}
