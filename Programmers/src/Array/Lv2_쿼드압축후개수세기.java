package Array;

import java.util.*;
public class Lv2_쿼드압축후개수세기 {
	static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
	}
	static public int[] solution(int[][] arr) {
        answer = new int[2];
        
        cntQuadTree(arr);
        
        System.out.println(answer[0]+" "+answer[1]);
        
        return answer;
    }
    //쿼드 트리 압축 개수
    static void cntQuadTree(int[][] arr){
        
        if(isSame(arr) || arr.length==1){
            answer[arr[0][0]]++;//모두 같은 숫자이면 압축해서 해당 값 추가.
            return;
        }
        int[][] copy = new int[arr.length/2][arr.length/2];
        //1사분면 복사
        for(int i=0;i<arr.length/2;i++)
            copy[i]=Arrays.copyOfRange(arr[i],0,arr.length/2);
        
        cntQuadTree(copy);
        
        //2사분면 복사
        for(int i=0;i<arr.length/2;i++)
            copy[i]=Arrays.copyOfRange(arr[i],arr.length/2,arr.length);
        
        cntQuadTree(copy);
        
        //3사분면 복사
        for(int i=arr.length/2;i<arr.length;i++)
            copy[i-arr.length/2]=Arrays.copyOfRange(arr[i],0,arr.length/2);
        
        cntQuadTree(copy);
        
        //4사분면 복사
        for(int i=arr.length/2;i<arr.length;i++)
            copy[i-arr.length/2]=Arrays.copyOfRange(arr[i],arr.length/2,arr.length);
        
        cntQuadTree(copy);
        
    }
    //arr배열 안의 값이 모두 같은지
    static boolean isSame(int[][] arr){ 
        int value=arr[0][0];
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]!=value) return false;
            }
        }
        
        return true;
    }
}
