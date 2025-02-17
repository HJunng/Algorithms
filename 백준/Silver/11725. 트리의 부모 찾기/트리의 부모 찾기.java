import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<Integer>> map;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		map = new HashMap<>();
		for(int i=1;i<=n;i++) {
			map.put(i, new ArrayList<>());
		}

		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map.get(a).add(b);
			map.get(b).add(a);
		}

		parent = new int[n+1];
		visited = new boolean[n+1];
		dfs(1);

		for(int i=2;i<=n;i++) {
			System.out.println(parent[i]);
		}
	}
	static void dfs(int start) {
		visited[start] = true;
		for(int child : map.get(start)) {
			if(!visited[child]) {
				parent[child] = start;
				dfs(child);
			}
		}
	}
}