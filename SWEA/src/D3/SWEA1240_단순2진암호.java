package D3;

import java.io.*;
import java.util.*;
public class SWEA1240_단순2진암호 {
	static String[] number = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		map = new HashMap<>();
		for(int i=0;i<number.length;i++)
			map.put(number[i], i);
		
		for(int t=1;t<=tc;t++) {
			
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);//세로 ->총 몇줄
			int M = Integer.parseInt(s[1]);// 가로 ->한줄에 몇개의 문자
			
			ArrayList<Integer> code = new ArrayList<>();
			int start=0;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				
				//"0"으로만 이뤄져있으면 검사할 필요 없음. + 이미 코드 얻었으면 검사할 필요 없음.
				if(!str.contains("1") || code.size()==8) continue;
				
				for(int j=str.length()-1;j>=6;j--) {
					
					if(str.charAt(j)=='1') {
						start=j-55;
						break;
					}
				}
				
				for(int j=0;j<8;j++) {
					String temp = str.substring(start+j*7,start+(j+1)*7);
					
					code.add(map.get(temp));
				}
				//System.out.println(code);
			}
			
			int check=0;
			int sum=0;
			for(int i=0;i<code.size();i++) {
				if(i%2!=0)
					check+=code.get(i);
				else
					check+=code.get(i)*3;
				
				sum+=code.get(i);
			}
			if(check%10==0)
				sb.append("#"+t+" "+sum+"\n");
			else
				sb.append("#"+t+" 0\n");
		}
		System.out.println(sb);
	}
}