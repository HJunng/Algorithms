package DevMatching;

import java.io.BufferedReader;
import java.util.*;

public class Num1 {
	public static String[] args;
	public static void main(String[] args) {
		
		int arr[][] = new int[2][3];
		
		System.out.println(arr.length);
		System.out.println(arr[1].length);
		
		Queue<int[]> q = new LinkedList<>();
		q.clear();
		q.add(null);
		countPattern(1,2);
	}
	private static void countPattern(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
