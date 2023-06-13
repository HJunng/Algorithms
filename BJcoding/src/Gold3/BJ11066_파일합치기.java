package Gold3;

import java.io.*;
import java.util.*;

public class BJ11066_파일합치기 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		String[] s;
		
		while(tc-->0) {
			int k = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			
			s = br.readLine().split(" ");
			
			for(int i=0;i<k;i++)
				list.add(Integer.parseInt(s[i]));
			
			sb.append(dp(list,0)).append("\n");
		}
		System.out.println(sb);
	}

	private static int dp(ArrayList<Integer> list, int sum) {
		if(list.size()==1)
			return sum;
		
		int minIndex=-1;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<list.size()-1;i++) {
			int temp = list.get(i)+list.get(i+1);
			if(temp<min) {
				min=temp;
				minIndex=i;
			}
		}
		
		list.remove(minIndex);
		list.remove(minIndex);
		list.add(minIndex, min);
		sum+=min;
		
		return dp(list,sum);
	}

}
