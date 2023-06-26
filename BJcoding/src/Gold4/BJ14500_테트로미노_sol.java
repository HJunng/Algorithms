package Gold4;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ14500_테트로미노_sol {
	static int[][] paper = new int [505][505];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		
		//paper 채워넣기.
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			
			for(int j=0;j<m;j++) {
				paper[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				//  ㅡ 모양
				pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i][j+3]); // ㅡ
				pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+3][j]); // ㅣ
				
				//  ㅁ 모양
				pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1]);
				
				//  7 모양
				pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]);
				pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j]+paper[i+2][j]);
				pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+2][j+1]);
				pq.add(paper[i+2][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]);
				pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j]);
				pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+2]);
				pq.add(paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
				pq.add(paper[i][j+2]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
				
				//  ㄹ 모양
				pq.add(paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+2][j+1]);
				pq.add(paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j]+paper[i+2][j]);
				pq.add(paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j+2]);
				pq.add(paper[i+1][j]+paper[i+1][j+1]+paper[i][j+1]+paper[i][j+2]);
				
				//  ㅜ 모양
				pq.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1]);
				pq.add(paper[i+1][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1]);
				pq.add(paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2]);
				pq.add(paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+1][j+1]);
				
				
				
			}
		}
		
		System.out.println(pq.poll());
		
		
	}

}
