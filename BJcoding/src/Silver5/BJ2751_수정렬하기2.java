package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2751_수정렬하기2 {		//65min. 답 봄.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) 
			list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		
		
		for(int a : list) {	//i에 list값 하나씩 대입 됨!! 외우기!!
			sb.append(a).append("\n");
		}
		System.out.println(sb);
		
		/*
		for(int i=0;i<N;i++) {		//for문 사용 줄이고자 선택정렬 사용.
			int min=i;
			for(int j=i+1;j<N;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			sb.append(a[i]).append("\n");
		}
		System.out.println(sb);
		*/
	}
}