
package inflearn;

import java.util.Scanner;

public class Eight {
	
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			char[] arr = input.toCharArray();
			
//			int left = 0;
//			int right = 0;
//			for(int i=0; i < arr.length; i++) {
//				if(arr[i] == 40) left++;
//				if(arr[i] == 41) right++;
//			}
			
			int cnt = 0;
			for(int i=0; i < arr.length; i++) {
				cnt += arr[i] == '(' ? 1 : -1;
				// 여는 괄호 없이 닫는 괄호부터 나온다면 break
				if(cnt < 0) {
					break;
				}
			}
			
			System.out.println(cnt == 0 ? "YES" : "NO");
		}
	}

}
