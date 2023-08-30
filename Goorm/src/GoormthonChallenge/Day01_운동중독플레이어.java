package GoormthonChallenge;

import java.io.*;
public class Day01_운동중독플레이어 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int w = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		
		double answer = w*(1+r/(double)30);
		
		System.out.println((int)answer);
	}
}
