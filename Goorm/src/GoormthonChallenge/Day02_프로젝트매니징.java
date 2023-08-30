package GoormthonChallenge;

import java.io.*;

public class Day02_프로젝트매니징 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tasks = Integer.parseInt(br.readLine());
		String[] startTime = br.readLine().split(" ");
		
		int times = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);//현재시각 -> 분으로 
		if(times>=1440) times%=1440;//하루가 넘어간다면 시간 바꿔주기
		
		for(int i=0;i<tasks;i++) times+=Integer.parseInt(br.readLine());
		
		if(times>=1440) times%=1440;//하루가 넘어간다면 시간 바꿔주기
		System.out.println(times/60 +" "+times%60);
	}

}
