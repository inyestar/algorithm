package algorithm.annotation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Stream;

import algorithm.sort.Sort;

/**
 * @Run 애너테이션이 붙은 Sort 자식을 실행하는 클래스
 * @author inye
 *
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
			Sort sort = getInstance();
			if(sort == null) {
				throw new ClassNotFoundException("No annotated class");
			}
			
			int[] original = new Random().ints(0, 100).distinct().limit(5).toArray();
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> before=%s%n", Arrays.toString(original));
			sort.doSort(original);
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> after=%s%n", Arrays.toString(original));
		
	}
	
	private static Sort getInstance() {
		Sort sort = null;
		try {
			
			String root = System.getProperty("java.class.path") + File.separator;
			Iterator<Path> paths = findByPath(Path.of(root)).iterator();
			while(paths.hasNext()) {
				File file = paths.next().toFile();
				String className = file.getAbsolutePath().replace(root, "");
				Class<?> clazz = Class.forName(className.substring(0, className.indexOf('.')).replace('\\', '.'));
				for(Annotation ano : clazz.getAnnotations()) {
					if(ano.annotationType().equals(Run.class)) {
						sort = (Sort) clazz.getConstructor().newInstance();
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
