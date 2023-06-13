package sweaAlgorithm;

import java.io.*;
import java.util.*;

public class No1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]= br.readLine().split(" ");
		
		int nowX = 0;
		int nowY = 0;
		
		int T = Integer.parseInt(str[0]);
		for(int k=0;k<T;k++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int result=0;
			String visited[] = new String[a*b];	//산 기념품 알파벳 저장
			
			String temp[][] = new String[a][b];
			for(int i=0;i<a;i++) {	//여행지 기념품 저장
				str = br.readLine().split("");
				for(int j=0;j<b;j++) {
					temp[i][j]=str[b];
				}
			}
			
			Queue<Integer> myqueue = new LinkedList<>();
			visited[0] = temp[0][0];
			
			while(true) {
				
			}
		}
	}

}
