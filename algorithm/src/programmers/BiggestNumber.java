package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BiggestNumber {
	
	public String solution(int[] numbers) {
		
		/*
		 * 1의 자리가 제일 큰게 앞에 오고
		 * 1의 자리가 같으면 10의 자리 중에서 큰거
		 * 그 다음은 3의 자리가 큰거 이렇게 정렬해야 할 듯
		 */
		
//		StringBuilder builder = new StringBuilder();
//		while(!numberList.isEmpty()) {
			
//			int maxIdx = IntStream.range(0, numberList.size()).reduce((i, j) -> {
//				int x = numberList.get(i);
//				int y = numberList.get(j);
//				
//				int xDigit = (int) Math.log10(x);
//				int yDigit = (int) Math.log10(y);
//				
//				int xFirst = x == 0 ? 0 : Math.floorDiv(x, (int) Math.pow(10, xDigit));
//				int yFirst = y == 0 ? 0 : Math.floorDiv(y, (int) Math.pow(10, yDigit));
//				
//				if (xFirst != yFirst) {
//					return xFirst < yFirst ? j : i;
//				}
//				
//				// xFist == yFirst
//				// 10,3 or 30, 3
//				if (xDigit > yDigit && x % 10 == 0) {
//					return j;
//				}
//				
//				// 1, 10 or 100, 100
//				if (xDigit < yDigit && y % 10 == 0) {
//					return i;
//				}
//				
//				return x < y ? j : i;
//			}).getAsInt();
			
//			int maxValue = numberList.get(maxIdx);
//			numberList.remove(maxIdx);
//			System.out.println(numberList);
//			builder.append(Integer.toString(maxValue));
//		}
//		feedback : 그냥 자꾸 틀리네... TC만 맞고
		
		/*
		 * ab와 bc를 비교하여 a,b를 정렬... 이렇게 단순한걸 왜 생각하지 못했을까 
		 */
		List<String> numberList = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());
		Collections.sort(numberList, (a, b) -> Integer.valueOf(b + a).compareTo(Integer.valueOf(a + b)));
		String answer = String.join("", numberList);
		
		if (answer.startsWith("0")) {
			return "0";
		}
		
		return answer;
		
}
	
	public static void main(String [] args) {
		
		int[] numbers1 = new int[] {6, 10, 2};
		int[] numbers2 = new int[] {3, 30, 34, 5, 9};
		int[] numbers3 = new int[] {0, 0, 0, 0, 0};
		int[] numbers4 = new int[] {1000, 100};
		int[] numbers5 = new int[] {1, 10, 100, 1000 };
		
		BiggestNumber solution = new BiggestNumber();
		System.out.println(solution.solution(numbers1));
		System.out.println(solution.solution(numbers2));
		System.out.println(solution.solution(numbers3));
		System.out.println(solution.solution(numbers4));
		System.out.println(solution.solution(numbers5));
		
	}
}
