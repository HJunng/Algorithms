package GoormthonChallenge;

import java.io.*;
import java.util.*;
public class Day06_문자열나누기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		Set<String> splitSet = new HashSet<>();
		ArrayList<String[]> order = new ArrayList<>();
		
		for(int i=1;i+1<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				splitSet.add(s.substring(0,i));
				splitSet.add(s.substring(i,j));
				splitSet.add(s.substring(j,s.length()));
				
				order.add(new String[]{s.substring(0,i),s.substring(i,j),s.substring(j,s.length())});
			}
		}
		
		ArrayList<String> split = new ArrayList<>(splitSet);
		Collections.sort(split);
		
		int score=0;
		for(String[] o: order){
			score=Math.max(score, split.indexOf(o[0])+split.indexOf(o[1])+split.indexOf(o[2])+3);
		}
		System.out.println(score);
		
	}
}
