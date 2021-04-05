package algorithm.recursive;

public class Palindrome {
	
	/**
	 * 문자열을 거꾸로 읽어도 원본과 동일한 회문인지 판단하는 함수
	 * 예) level
	 * @param args
	 */
	boolean loop(String org) {
		
		char[] arr = org.toCharArray();
		int len = arr.length;
		char[] newArr = new char[len];
		for(int i=len - 1; i>=0; i--) {
			newArr[len - 1 - i] = arr[i];
		}
		String reversed = new String(newArr);
//		String reversed = org.chars().mapToObj(c -> (char)c).reduce("", (s,c) -> c+s, (s1, s2) -> s2+s1);
		System.out.println(reversed);
		return org.equals(reversed);		
	}
	
	boolean recursive(String org) {
		
		org = org.toLowerCase();
		if(org.length() <= 1) {
			return true;
		}
		
		char[] arr = org.toCharArray();
		if(arr[0] == arr[arr.length-1]) {
			char[] newChar = new char[arr.length-2];
			System.arraycopy(arr, 1, newChar, 0, newChar.length);
			return recursive(new String(newChar));
		}
		return false;
		
	}

	public static void main(String[] args) {
		
		Palindrome p = new Palindrome();
		System.out.println(p.recursive("inye"));
	}
}
