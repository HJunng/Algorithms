import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			String s = br.readLine();
			
			char first = s.charAt(0);
			char last = s.charAt(s.length()-1);
			
			// 시작문자가 A,B,C,D,E,F 가 아니면 Good 출력 
			if(first!='A' && first!='B' && first!='C' && first!='D' && first!='E' && first!='F') {
				System.out.println("Good");
				continue;
			}
			if(first!='A') s = s.substring(1,s.length());
			
			// 끝문자가 A,B,C,D,E,F 가 아니면 Good 출력 
			if(last!='A' && last!='B' && last!='C' && last!='D' && last!='E' && last!='F') {
				System.out.println("Good");
				continue;
			}
			if(last!='C') s = s.substring(0,s.length()-1);
			
			// 겹치는 문자 지우기.
			for(int i=1;i<s.length();i++) {
				if(s.charAt(i)==s.charAt(i-1)) {
					s = s.substring(0,i-1) + s.substring(i,s.length());
					i--;
				}
			}
			
			if(s.equals("AFC")) System.out.println("Infected!");
			else System.out.println("Good");
		}
	}
}