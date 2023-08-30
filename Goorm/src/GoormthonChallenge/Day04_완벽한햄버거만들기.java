package GoormthonChallenge;

import java.io.*;
import java.util.*;

public class Day04_완벽한햄버거만들기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		int[] ing = new int[cnt];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<cnt;i++) ing[i]=Integer.parseInt(s[i]);
		
		int leftIdx = 0;
		for(int i=0;i<cnt;i++){
			if(ing[i]<ing[leftIdx]) break;
			leftIdx=i;
		}
		
		int rightIdx=cnt-1;
		for(int i=cnt-1;i>=0;i--){
			if(ing[i]<ing[rightIdx]) break;
			rightIdx=i;
		}
		
		if(leftIdx>=rightIdx) System.out.println(Arrays.stream(ing).sum());
		else System.out.println(0);
	}

}
