package programmers;

import java.util.Arrays;

public class PhoneBook {
	
	public boolean solution(String[] phone_book) {
		
		
		Arrays.sort(phone_book);
		
//		for(String a : phone_book) {
//			for (String b : phone_book) {
//				if(b.startsWith(a)) {
//					return false;
//				}
//			}
//		}
//  	feedback : 자기 자신 제거 필요
		
//		for (int i=0; i<phone_book.length; i++) {
//			for(int j=i+1; j<phone_book.length; j++) {
//				if(phone_book[j].startsWith(phone_book[i])) {
//					return false;
//				}
//			}
//		}
//		feedback : 이미 정렬 되어 있으므로 이중 포문 제거 필요
		
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		String[] phoneBook1 = new String[] {"119", "97674223", "1195524421"};
		String[] phoneBook2 = new String[] {"123", "456", "789"};
		String[] phoneBook3 = new String[] {"12", "123", "1235", "567", "88"};
		String[] phoneBook4 = new String[] {"11", "12", "111"};
		
		PhoneBook solution = new PhoneBook();
		solution.solution(phoneBook1);
		solution.solution(phoneBook2);
		solution.solution(phoneBook3);
		solution.solution(phoneBook4);		
		
	}

}
