import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); // 임스와 플레이하기를 신청한 횟수
		char game = s[1].charAt(0);
		
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		int needsPeople = 0;
		if(game=='Y') needsPeople=1;
		else if(game=='F') needsPeople=2;
		else needsPeople=3;
		
		System.out.println(set.size()/needsPeople);

	}
}