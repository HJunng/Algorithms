package Silver2;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class BJ2644_촌수계산 {
	static Map<Integer,ArrayList<Integer>> family = new HashMap<>();
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int people = Integer.parseInt(br.readLine());//사람 수
		
		for(int i=1;i<=people;i++) family.put(i,new ArrayList<>());
		
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);//출발
		int end = Integer.parseInt(s[1]);//도착
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			//받아온 두 개의 숫자를 int[]배열에 넣어줌.
			int[] connect = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			family.get(connect[0]).add(connect[1]);
			family.get(connect[1]).add(connect[0]);
		}
		visited = new boolean[people+1];
		
		System.out.println(bfs(start,end));
		
	}
	static int bfs(int start, int end) {
		
		int degree=-1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start,0});
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0]==end) { degree=now[1];break;}
			
			for(int i:family.get(now[0])) {
				if(visited[i]) continue;
				
				visited[i]=true;
				q.offer(new int[] {i,now[1]+1});
			}
		}
		return degree;
	}
}
