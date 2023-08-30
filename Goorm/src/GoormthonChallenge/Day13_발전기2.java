package GoormthonChallenge;

import java.io.*;
import java.util.*;

public class Day13_발전기2 {
	static int[][] town;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//마을 크기
		int k = Integer.parseInt(s[1]);//단지 제한 개수
		
		town = new int[n][n];
		for(int i=0;i<n;i++){
			s = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				town[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		Map<Integer,Integer> complexCnt = new HashMap<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int type = town[i][j];
				if(type>0 && isComplex(i,j,n,k)){
					complexCnt.put(type,complexCnt.getOrDefault(type,0)+1);
				}
			}
		}
		
		int answer=0;
		int maxCnt=0;
		for(int key:complexCnt.keySet()){
			if(complexCnt.get(key)>maxCnt){
				maxCnt=complexCnt.get(key);
				answer=key;
			}else if(complexCnt.get(key)==maxCnt){
				answer=answer>key?answer:key;
			}
		}
		System.out.println(answer);
	}
	static boolean isComplex(int x, int y, int n, int k){
		
		int[] dx={1,-1,0,0};
		int[] dy={0,0,1,-1};		
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});//처음 건물 시작 위치
		int type = town[x][y];;//건물 유형
		
		town[x][y]=-1;//방문처리
		int cnt=0;
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			cnt++;
			
			for(int i=0;i<4;i++){
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && town[nx][ny]==type){
					town[nx][ny]=-1;//방문처리
					q.add(new int[]{nx, ny});
				}
			}
		}
		
		if(cnt>=k) return true;
		else return false;
	}
}
