package GoormthonChallenge;

import java.util.*;
import java.io.*;

public class Day15_과일구매 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//과일 개수
		int k = Integer.parseInt(s[1]);//플레이어가 가진 돈
		
		ArrayList<int[]> fruits = new ArrayList<>();
		for(int i=0;i<n;i++){
			s = br.readLine().split(" ");
			fruits.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});//과일가격,포만감
		}
		//가격 1당 포만감이 많이 차는 순으로 과일 정렬
		Collections.sort(fruits, (a,b)->b[1]/b[0] - a[1]/a[0]);
		
		long full=0;
		for(int[] fruit: fruits){
			if(k==0) break;
			
			if(k>=fruit[0]){
				k-=fruit[0];
				full+=fruit[1];
			}else{
				full+=fruit[1]/fruit[0]*k;
				k=0;
			}
		}
		System.out.println(full);
	}
}
