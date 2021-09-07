package practice.second;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class KeyLogger {
	
	/**
	 * 시뮬레이션 방식으로 풀이
	 * @param testCase
	 * @return
	 */
	private static String practice(String testCase) {
		StringBuilder tmp = new StringBuilder();
		int cursor = 0;		
		for(int i=0; i<testCase.length(); i++) {
			char c = testCase.charAt(i);
			switch(c) {
			case '-':
				if(tmp.isEmpty()) {
					continue;
				}
				tmp.deleteCharAt(--cursor);
				break;
			case '<':
				if(tmp.isEmpty()) {
					continue;
				}
				cursor--;
				break;
			case '>':
				try {
					tmp.charAt(cursor);
				} catch (IndexOutOfBoundsException e) {
					continue;
				}
				cursor++;
				break;
			default:
				tmp.insert(cursor, c);
				cursor++;
			}
		}
		
		return tmp.toString();
	}
	
	/**
	 * 알고리즘을 이용하여 풀이
	 * 문자열 크기가 최대 1,000,000
	 * @param testCase
	 * @return
	 */
	private static String answer(String testCase) {
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
			
		for(char c : testCase.toCharArray()) {
			switch(c) {
			case '-':
				if(!left.isEmpty()) {
					left.pop();
				}
				break;
			case '<':
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case '>':
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			default:
				left.push(c);
			}
		}
		
		return left.stream().map(String::valueOf).collect(Collectors.joining("")) + new StringBuilder(right.stream().map(String::valueOf).collect(Collectors.joining(""))).reverse().toString();
	}
	
	/**
	 * 주어진 문자열에 문자에 따라 문자 조합
	 * - : 백 스페이스로 앞 문자열 지움
	 * > : cursor 왼쪽으로 이동
	 * < : cursor 오른쪽으로 이동
	 * 
	 * (백준 : https://www.acmicpc.net/problem/5397)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int loop = scanner.nextInt();
			while(loop-- > 0) {
				String testCase = scanner.next();
				System.out.println(practice(testCase));
				System.out.println(answer(testCase));
				
			}
		}
	}

}
