package practice.first;

import java.util.Scanner;

public class Scale {
	
	private String howToPlay(int[] playOrder) {
		
		boolean ascending = true;
		boolean descending = true;
		
		for(int i=1; i<playOrder.length; i++) {
			if (playOrder[i] > playOrder[i-1]) {
				descending = false;
			} 
			if (playOrder[i] < playOrder[i-1]) {
				ascending = false;
			}
		}
		
		if(ascending) {
			return "ascending";
		} else if (descending) {
			return "descending";
		} else {
			return "mixed";
		}
	}
	
	/**
	 * C major : c d e f g a b C -> 1, 2, 3, 4, 5, 6, 7, 8
	 * ascending : 1 to 8
	 * descending : 8 to 1
	 * mixed : others
	 * (백준 : https://www.acmicpc.net/problem/2920)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] played = new int[8];
		try(Scanner scanner = new Scanner(System.in);) {
			int i = 0;
			while(scanner.hasNextInt()) {
				played[i++] = scanner.nextInt();
				if(i == played.length) {
					break;
				}
			}
		}
		String result = new Scale().howToPlay(played);
		System.out.println(result);
	}

}
