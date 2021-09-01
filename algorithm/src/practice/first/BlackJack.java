package practice.first;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BlackJack {
	
	private static int MIN_COUNT = 3;
	private static int MAX_COUNT = 100;
	
	private static int MIN_SUM = 10;
	private static int MAX_SUM  = 300000;
	
	private static int POSITIVE = 1;
	
	/**
	 * 카드 랜덤으로 뽑아 주기
	 * @param cnt
	 * @param sum
	 * @return
	 */
	private int[] showCards(int cnt, int sum) {
		
		if (cnt < MIN_COUNT || cnt > MAX_COUNT) {
			throw new RuntimeException("Unsatisfied count");
		}
		
		if (sum < MIN_SUM || sum > MAX_SUM) {
			throw new RuntimeException("Unsatisfied summation");
		}
		
		return new Random().ints(cnt, POSITIVE, sum).toArray();
	}
	
	
	/**
	 * 재귀 함수를 이용한 3가지 숫자 뽑기
	 * @param length
	 * @param start
	 * @param cnt
	 * @param set
	 */
	private void getBestCombination(int length, int start, int cnt, Set<Integer> set) {
		
		if (cnt == 0) {
			for (int i : set) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		for (int j=start; j<length; j++) {
			set.add(j);
			getBestCombination(length, j+1, cnt-1, set);
			set.remove(j);
		}
		
	}
	
	
	/**
	 * 3중 루프를 사용한 조합 구하기
	 * @param cards
	 * @param sum
	 * @return
	 */
	private int getBestCombination(int[] cards, int sum) {

		int length = cards.length;
		int temp = 0;
		int best = 0;
		
		for(int i=0; i<length; i++) {
			for(int j=i+1; j<length; j++) {
				for(int z=j+1; z<length; z++) {
					temp = cards[i] + cards[j] + cards[z];
					if (temp == sum) {
						return temp;
					}
					if (temp <= sum && temp > best){
						best = temp;
					}
				}
			}
		}
		
		return best;
	}

	/**
	 * N(3 <= n <= 100)개의 카드 중 
	 * 숫자가 100000을 넘지 않는 카드 중 <br/>
	 * 합이 M (10 <= M <= 300000) 보다 크지 않으면서 M에 최대한 가까울 수 있는 숫자 3개의 합을 출력
	 * (백준 : https://www.acmicpc.net/problem/2798)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] input = new int[2];
		int[] cards = null;
		try(Scanner scanner = new Scanner(System.in);) {
			int idx = 0;
			while(scanner.hasNext()) {
				if (idx < input.length) {
					input[idx++] = scanner.nextInt();
					continue;
				}
				
				if (cards == null) {
					cards = new int[input[0]];
				}
				cards[idx++ - input.length] = scanner.nextInt();
				
				if(idx == cards.length + input.length) {
					break;
				}
			}
		}
		
		BlackJack game = new BlackJack();
		System.out.println(game.getBestCombination(cards, input[1]));
		
	}

}
