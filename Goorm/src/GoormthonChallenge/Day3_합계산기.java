package GoormthonChallenge;

import java.io.*;

public class Day3_합계산기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int sum=0;
		
		for(int i=0;i<cnt;i++){
			String[] cal = br.readLine().split(" ");
			
			if(cal[1].equals("+")){
				sum+=Integer.parseInt(cal[0])+Integer.parseInt(cal[2]);
			}else if(cal[1].equals("-")){
				sum+=Integer.parseInt(cal[0])-Integer.parseInt(cal[2]);
			}else if(cal[1].equals("*")){
				sum+=Integer.parseInt(cal[0])*Integer.parseInt(cal[2]);
			}else{
				sum+=Integer.parseInt(cal[0])/Integer.parseInt(cal[2]);
			}
		}
		 System.out.println(sum);
	}

}
