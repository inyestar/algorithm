package inflearn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Four {
	
	public static void main(String[] args) {
		
		try {
			// current path는 워크스페이스
			// class path는 워크스페이스/패키지명/bin/*
			List<String> lines = Files.readAllLines(Path.of("algorithm/src/inflearn/files/input.txt"));
			int[] ages = Arrays.stream(lines.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
			
			// int min = 2147000000;
			// int max = -2147000000;
			int min = ages[0];
			int max = ages[0];
			for(int i=1; i<ages.length; i++) {
				min = min > ages[i] ? ages[i] : min; // Arrays.stream(ages).min()
				max = max < ages[i] ? ages[i] : max; // Arrays.stream(ages).max()
			}
			
			int diff = max - min;
			// stream.sorted().toArray()에서 ages[0] - ages[ages.length - 1]
			System.out.println(diff);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
