package Bronze3;

import java.io.*;
public class BJ11721_열개씩끊어출력하기 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for(int i=0;i<s.length()/10+1;i++) {
			if(i*10+10>s.length()) // outOfBounds
				System.out.println(s.substring(i*10));
			else
				System.out.println(s.substring(i*10,i*10+10));
		}
	}
}