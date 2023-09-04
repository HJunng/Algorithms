package GoormthonChallenge;

import java.io.*;
import java.util.*;

public class Day16_연합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//섬의 개수
		int m = Integer.parseInt(s[1]);//다리의 개수
		
		Map<Integer,Set<Integer>> bridge = new HashMap<>();//그래프 초기화
		for(int i=1;i<=n;i++) bridge.put(i,new HashSet<>());
		
		for(int i=0;i<m;i++){
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			bridge.get(a).add(b);//a->b 다리 연결
		}
		
		int[] parent = new int[n+1];
		for(int i=1;i<=n;i++){
			if(parent[i]==0) parent[i]=i;//일단 자기자신을 부모노드로 초기화
			
			for(int j : bridge.get(i)){
				if(j>i && bridge.get(j).contains(i)){
					if(parent[j]>0){
						int small = Math.min(parent[i],parent[j]);
						int big = Math.max(parent[i],parent[j]);
						
						for(int k=1;k<=n;k++){
							if(parent[k]==big) parent[k]=small;
						}
					}else
						parent[j]=parent[i];
				}
			}
		}
		
		Set<Integer> parentUnion = new HashSet<>();
		for(int i=1;i<=n;i++) parentUnion.add(parent[i]);
		
		System.out.println(parentUnion.size());
	}

}
