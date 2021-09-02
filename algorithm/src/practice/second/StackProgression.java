package practice.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackProgression {
	
	/**
	 * push : 자로 넣기 (오름 차순) + 
	 * pop : 자료 뽑기 - (내림 차순)
	 * Last In, First Out
	 * (백준 : https://www.acmicpc.net/problem/1874)
	 * 문제 설명이랑 실제 로직하고 너무 다른거 아닌가요?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			if (n <= 0) {
				throw new RuntimeException("It should be greater than zero");
			}
			List<String> result = new ArrayList<>();
			List<Integer> stack = new ArrayList<>();
			int cnt = 1; // 넣은 수
			for(int i=1; i<=n; i++) {
				int data = scanner.nextInt();
				while( cnt <= data) {
					stack.add(cnt++); // 푸쉬는 오름차순
					result.add("+");
				}
				
				// 최상위 원소가 데이터랑 같을 때만 pop 가능
				if (stack.get(stack.size() - 1) == data) {
					stack.remove(stack.size() - 1);
					result.add("-");
				} else {
					System.out.println("No");
					result = null;
					break;
				}
			}
			if (result != null) {
				result.forEach(System.out::println);
			}
		}
		
	}
}
