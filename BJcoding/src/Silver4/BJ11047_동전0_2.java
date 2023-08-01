package Silver4;

import java.io.*;
import java.util.ArrayList;

public class BJ11047_동전0_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n=Integer.parseInt(s[0]);//주어지는 동전 수
		int k = Integer.parseInt(s[1]);//동전 가치
		
		ArrayList<Integer> worth = new ArrayList<>();
		for(int i=0;i<n;i++) worth.add(Integer.parseInt(br.readLine()));
		
		int cnt=0;
		//동전을 최소한으로 쓰기 위해  가치가 큰 동전부터 가져온다.
		for(int i=n-1;i>=0;i--) {
			if(k==0) break;
			cnt+=k/worth.get(i);
			k%=worth.get(i);
		}
		System.out.println(cnt);
	}
}
