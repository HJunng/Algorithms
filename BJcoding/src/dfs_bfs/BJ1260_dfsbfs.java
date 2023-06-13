package dfs_bfs;
import java.util.*;
import java.io.*;
public class BJ1260_dfsbfs {

	static int map[][];	//main함수 말고 다른데서도 사용.
	static int visit[];
	static Queue<Integer> queue = new LinkedList<>();

/* 이 예시 해보면 오류나서 재귀함수로 바꿈.
5 5 1
1 2
2 3
3 1
1 4
3 5
*/
	static void DepthFirstSearch(int start) {
		visit[start] = 1;
		for(int j = 1;j<map.length;j++) {
			if(map[start][j]==1 && visit[j]!=1) {
				System.out.print(" "+j);
				DepthFirstSearch(j);			//재귀함수 중요!!
			}
		}
	}
	
	static void BreathFirstSearch(int start) {
		System.out.print(start);
		
		for(int i=1;i<map.length;i++) {
			for(int j=1;j<map.length;j++) {
				if(map[start][j]==1 && visit[j]!=0) {
					System.out.print(" "+j);
					visit[j]=0;
					queue.offer(j);
				}
			}
			if(queue.isEmpty())
				break;
			start = queue.poll();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//아래 외우기!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		
		int nodes = Integer.parseInt(str[0]);
		int edges = Integer.parseInt(str[1]);
		int start = Integer.parseInt(str[2]);
		map = new int[nodes+1][nodes+1];
		visit = new int[nodes+1];
		visit[start] = 1;
		
		for(int i=0;i<edges;i++) {	//그래프 채우기
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			map[a][b] = map[b][a] = 1;
			
		}

		System.out.print(start);
		DepthFirstSearch(start);
		System.out.println();
		//visit 다시 0으로 만들기
		visit[start] = 0;
		BreathFirstSearch(start);
		
	}
}
