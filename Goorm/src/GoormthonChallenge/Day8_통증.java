package GoormthonChallenge;

import java.io.*;
public class Day8_통증 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pain = Integer.parseInt(br.readLine());
		
		int answer=0;// 아이템 사용 최소 갯수
		
		int[] items = {14,7,1}; //painkiller, medicine, bandage
		
		for(int i=0;i<items.length;i++){
			
			answer+=pain/items[i];
			pain%=items[i];
		}
		
		System.out.println(answer);
	}

}
