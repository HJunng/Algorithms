package Silver5;

import java.io.*;

public class BJ2941 {	//36min		여러가지 방법 해보다가 이게 제일 쉬운거라고 알게됨.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.replace("c=", "c");	//문자열 안에 "c="가 있으면 모두 c로 치환해서 저장 str= 없으면 저장안됨.
		str = str.replace("c-","c");
		str = str.replace("dz=", "d");
		str = str.replace("d-", "d");
		str = str.replace("lj", "l");
		str = str.replace("nj","n");
		str = str.replace("s=", "s");
		str = str.replace("z=","z");
		
		System.out.println(str.length());
	}
}
