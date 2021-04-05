package algorithm.annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Run 애너테이션이 붙은 Sort 자식을 실행하는 클래스
 * @author inye
 *
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
			Callee call = getInstance();
			if(call == null) {
				throw new ClassNotFoundException("No annotated class");
			}
			int[] original = new Random().ints(0, 100).distinct().limit(5).toArray();
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> Class=%s%n", call.getClass().getName());
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> original=%s%n", Arrays.toString(original));
			call.doCall(original);
	}
	
	private static Callee getInstance() {
		Callee sort = null;
		try {
			
			String root = System.getProperty("java.class.path") + File.separator;
			Iterator<Path> paths = findByPath(Path.of(root)).iterator();
			while(paths.hasNext()) {
				File file = paths.next().toFile();
				String className = file.getAbsolutePath().replace(root, "");
				Class<?> clazz = Class.forName(className.substring(0, className.indexOf('.')).replace('\\', '.'));
				for(Annotation ano : clazz.getAnnotations()) {
					if(ano.annotationType().equals(Run.class)) {
						sort = (Callee) clazz.getConstructor().newInstance();
						break;
					}
				}
				if(sort != null) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sort;
	}
	
	private static Stream<Path> findByPath(Path dir) {
		try {
			return Files.list(dir).flatMap(path -> path.toFile().isDirectory() ? findByPath(path) : Collections.singletonList(path).stream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
