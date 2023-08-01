package Gold3;

import java.io.*;
import java.util.*;

public class BJ2457_공주님의정원 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int start = changeToDay(3,1);
		int end = changeToDay(11,30);
		
		String[] s;
		
		int[][] flower = new int[n][2];//개화시기,낙화시기
		for(int i=0;i<n;i++) {
			s=br.readLine().split(" ");
			
			flower[i][0]=changeToDay(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			flower[i][1]=changeToDay(Integer.parseInt(s[2]),Integer.parseInt(s[3]));
		}
		//개화시기 순, 피어있는 기간이 긴 순으로 정렬
		Arrays.sort(flower,new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return (b[1]-b[0])-(a[1]-b[0]);
				else return a[0]-b[0];
			}
		});
		
		int now=start;//현재 날짜(일)
		int cnt=0;//최소한의 꽃 개수
		while(now<=end) {
			int maxEnd=-1;//낙화 시기가 가장 뒤인 꽃
			for(int i=0;i<flower.length;i++) {
				if(flower[i][0]<=now && flower[i][1]>now && flower[i][1]>maxEnd)
					maxEnd=flower[i][1];
			}
			//이어지는 꽃이 없다면 0 출력.
			if(maxEnd==-1) {
				System.out.println(0);
				return;
			}
			cnt++;
			now=maxEnd;
		}
		
		System.out.println(cnt);
		
	}
	static int changeToDay(int mm, int dd) {
		
		int day=dd;
		mm-=1;
		while(mm>0) {
			if(mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12)
				day+=31;
			else if(mm==2)
				day+=28;
			else
				day+=30;
			mm--;
		}
		return day;
	}
}
