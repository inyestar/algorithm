package inflearn;

import java.util.Scanner;

public class Eighteen {
	
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			int[] measurements = new int[n];
			int idx = 0;
			while(idx < n) {
				measurements[idx++] = scanner.nextInt();
			}
			
			int duration = 0;
			int max = 0;
			for(int i=0; i<measurements.length; i++) {
				if(measurements[i] <= m) {
					duration = 0;
				} else {
					duration++;
				}
				
				if(max < duration) {
					max = duration;
				}
			}
			System.out.println(max == 0 ? -1 : max);
		}
	}

}
