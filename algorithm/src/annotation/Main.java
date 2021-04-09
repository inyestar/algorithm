package annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
			Caller caller = getInstance();
			if(caller == null) {
				throw new ClassNotFoundException("No annotated class");
			}
			int[] original = new Random().ints(0, 100).distinct().limit(5).toArray();
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> Class=%s%n", caller.getClass().getName());
			System.out.printf(">>>>>>>>>>>>>>>>>>>>> original=%s%n", Arrays.toString(original));
			caller.call(original);
	}
	
	/**
	 * Caller를 상속받고 run 애너테이션을 갖고 있는 인스턴스 찾기
	 * @return
	 */
	private static Caller getInstance() {
		Caller sort = null;
		try {
			
			String root = System.getProperty("java.class.path") + File.separator;
			Stream<Path> pathStream = findByPath(Path.of(root));
			if(pathStream == null) {
				return sort;
			}
			Iterator<Path> paths = pathStream.iterator();
			while(paths.hasNext()) {
				File file = paths.next().toFile();
				String className = file.getAbsolutePath().replace(root, "");
				Class<?> clazz = Class.forName(className.substring(0, className.indexOf('.')).replace('\\', '.'));
				for(Annotation ano : clazz.getAnnotations()) {
					if(ano.annotationType().equals(Run.class)) {
						sort = (Caller) clazz.getConstructor().newInstance();
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
	
	/**
	 * Path 아래의 파일 리스트만 출력
	 * @param dir
	 * @return
	 */
	private static Stream<Path> findByPath(Path dir) {
		try {
			return Files.list(dir).flatMap(path -> path.toFile().isDirectory() ? findByPath(path) : Collections.singletonList(path).stream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
