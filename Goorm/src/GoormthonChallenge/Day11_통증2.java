package GoormthonChallenge;

import java.io.*;
import java.util.*;
public class Day11_통증2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner s = new Scanner(System.in);
		
		int pain = s.nextInt();
		int a = s.nextInt();
		int b = s.nextInt();
		
		int answer=-1;
		for(int i=0;i<=pain/a;i++){
			int cnt=i;
			int now = pain-a*i;
			
			if(now%b==0){
				cnt+=now/b;
				if(answer==-1 || cnt<answer) answer=cnt;
			}
		}
		
		System.out.println(answer);
	}

}
