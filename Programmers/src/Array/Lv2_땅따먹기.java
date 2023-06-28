package Array;

public class Lv2_땅따먹기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int solution(int[][] land) {
        int answer = 0;

        int max=0; // 최고점
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                int iMax=0; // (i-1)행에서 같은 열이 아닌 값 중에 가장 큰 값.
                
                if(j!=0) iMax=Math.max(iMax,land[i-1][0]);
                if(j!=1) iMax=Math.max(iMax,land[i-1][1]);
                if(j!=2) iMax=Math.max(iMax,land[i-1][2]);
                if(j!=3) iMax=Math.max(iMax,land[i-1][3]);
                
                land[i][j]+=iMax; // 자기자신의 값 + 이전 열의 가장 큰 값
                
                if(i==land.length-1 && land[i][j]>max) max=land[i][j];
            }
        }
        return max;
    }
}
