package Bronze1;

import java.io.*;
public class BJ2869_달팽이_2 {	//10min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int v = Integer.parseInt(str[2]);
		
		if((v-a)%(a-b)==0)
			System.out.println((v-a)/(a-b)+1);
		else
			System.out.println((v-a)/(a-b)+2);
	}
}