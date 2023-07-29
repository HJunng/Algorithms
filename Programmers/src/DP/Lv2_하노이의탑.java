package DP;

import java.util.*;
public class Lv2_하노이의탑 {
	static ArrayList<int[]> ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int[][] solution(int n) {
        int[][] answer = {};
        
        ans = new ArrayList<>();
        
        hanoi(n,1,3,2);
        
        answer = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
            answer[i]=ans.get(i);
        
        return answer;
    }
    static void hanoi(int n, int from, int to, int mid){
        
        if(n==1){
            ans.add(new int[]{from,to});
            return;
        }
        
        //1. 1번 기둥의 n-1개의 원판을 도착지가 아닌 다른 지점으로 먼저 옮기기
        hanoi(n-1,from,mid,to);
        
        //2. 1번 기둥의 n번째 원판을 도착지에 옮기기
        hanoi(1,from,to,mid);
        
        //3. 도착지 아닌 곳에 옮겼던 n-1개의 원판을 도착지에 옮기기
        hanoi(n-1,mid,to,from);
        
    }
}
