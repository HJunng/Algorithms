package Gold4;

import java.io.*;
import java.util.Arrays;

public class BJ2110_공유기설치 {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int min = 1; // 최소 거리가 가질 수 있는 최솟값
		int max = arr[N-1]-arr[0]+1; // 최소 거리 최댓값
		
		while(min<max) {
			
			int half = (min+max)/2;
			
			//설치가능한 공유기 개수가 C개수에 못미치면 거리를 좁혀야 하기 때문에 max 줄인다.
			if(canInstall(half)<C) {
				max = half;
			}else {
				/**
				 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
				 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
				 * 찾아낸다.
				 */
				min = half+1;
			}
		}
		
		/*
		 *  Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로, 
		 *  1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
		 */
		
		System.out.println(min-1);
	}
	
	//dis에 대해 설치 가능한 공유기 개수 찾는 메소드
	private static int canInstall(int dis) {
		
		//첫번째 집은 무조건 설치한다고 가정
		int count=1;
		int lastLocate = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			int locate = arr[i];
			
			/*
			 *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 *  최소 거리(dis)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
			 *  마지막 설치 위치를 갱신해준다. 
			 */
			
			if(locate-lastLocate>=dis) {
				count++;
				lastLocate=locate;
			}
		}
		return count;
	}
}