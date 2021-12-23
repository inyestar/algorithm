package datastructure.hash;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		HashMap<String, Alarm> map = new HashMap<>();
		IntStream.range(0, 10)
			.forEach(x -> {
				map.put("person" + x, new Alarm(x, 0));
			});
		System.out.println(map);
		System.out.println(map.get("person8"));
	}
	
	static class Alarm {
		int hour;
		int minute;
		
		Alarm(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}
		
		public String toString() {
			return new StringBuilder()
					.append(hour)
					.append(":")
					.append(minute)
					.toString();
		}
	}
}
