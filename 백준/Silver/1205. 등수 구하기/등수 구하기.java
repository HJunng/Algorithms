import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); // 점수 리스트의 개수 
		int newScore = Integer.parseInt(s[1]); // 새로운 점수 
		int P = Integer.parseInt(s[2]); // 랭킹 리스트에 올라갈 수 있는 점수의 개수
		
		if(N>0) s = br.readLine().split(" ");
		Map<Integer,Integer> scoreCnt = new HashMap<>();
		for(int i=0;i<N;i++) {
			int score = Integer.parseInt(s[i]);
			scoreCnt.put(score, scoreCnt.getOrDefault(score, 0)+1);
		}
		scoreCnt.put(newScore, scoreCnt.getOrDefault(newScore,0)+1);
		
		ArrayList<Integer> scoreOrder = new ArrayList<>(scoreCnt.keySet());
		Collections.sort(scoreOrder,Collections.reverseOrder());
		
		Map<Integer,Integer> scoreRank = new HashMap<>();
		int rank=1;
		int total=0;
		for(int score : scoreOrder) {
			scoreRank.put(score, rank);
			total+=scoreCnt.get(score);
			
			if(score==newScore && total>P) {
				System.out.println(-1);
				return;
			}
			
			rank+=scoreCnt.get(score);
		}
		
		if(scoreRank.get(newScore)<=P) System.out.println(scoreRank.get(newScore));
		else System.out.println(-1);
		
	}
}