package datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	static void bfs(int[][] arr) {
		boolean[] visited = new boolean[arr.length]; // 방문처리
		Deque<Integer> queue = new ArrayDeque<>();
		int start = 1;
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for(int i=0; i<arr[x].length; i++) {
				int y = arr[x][i];
				if(!visited[y]) {
					queue.add(y);
					visited[y] = true;
				}
			}
		}
	}
	
	static void dfs(int[][] arr) {
		boolean[] visited = new boolean[arr.length]; // 방문처리
		Deque<Integer> stack = new ArrayDeque<>();
		int start = 1;
		visited[start] = true;
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int x = stack.pop();
			System.out.print(x + " ");
			for(int i=0; i<arr[x].length; i++) {
				int y = arr[x][i];
				if(!visited[y]) {
					stack.push(y);
					visited[y] = true;
				}
			}
		}
	}

	static void dfs(int[][] a, boolean[] c, int x) {
		if (c[x]) {
			return;
		}
		c[x] = true;
		System.out.print(x + " ");
		for(int i=0; i < a[x].length; i++) {
			int y = a[x][i];
			dfs(a, c, y);
		}
	}
	
	public static void main(String[] args) {
		
		int[][] arr = new int[][] {
				null,
				{2, 3},
				{1, 3, 4, 5},
				{1, 2, 6, 7},
				{2, 5},
				{2, 4},
				{3, 7},
				{3, 6}
		};
		
		bfs(arr);
		System.out.println();
		dfs(arr);
		System.out.println();
		boolean [] c = new boolean[8];
		dfs(arr, c, 1);
	}

}
