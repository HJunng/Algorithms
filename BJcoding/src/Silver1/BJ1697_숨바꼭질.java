package Silver1;

import java.util.*;
public class BJ1697_숨바꼭질 { //답 참고. 다시 풀기.
	static int end;
	static int visited[] = new int[1000001];

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		end = s.nextInt();
		
		if(start>end) {
			System.out.println(start-end);
			return;
		}
		
		
		bfs(start);
		
		//start를 1부터 세었으니 -1해주어야함.
		System.out.println(visited[end]-1);
	}

	private static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		visited[start]=1; //원래는 0이지만 방문했다는 걸 알리기 위해 1로 함.
		q.add(start);
		
		while(q.size()>0) {
			int now = q.poll();
			
			//도착
			if(now==end)
				return;
			//좌
			if(now-1>=0 && visited[now-1]==0) {
				visited[now-1]=visited[now]+1;
				q.add(now-1);
			}
			//우
			if(now+1<=100000 && visited[now+1]==0) {
				visited[now+1]=visited[now]+1;
				q.add(now+1);
			}
			//순간이동
			if(2*now<=100000 && visited[2*now]==0) {
				visited[now*2]=visited[now]+1;
				q.add(now*2);
			}
		}
	}
}