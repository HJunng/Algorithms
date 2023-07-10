package Array;

public class Lv2_삼각달팽이 {
	static int[] dx={1,0,-1};//움직이는 방향
    static int[] dy={0,1,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(4);
	}
	static public int[] solution(int n) {
        int[] answer = {};
        
        int[][] arr = new int[n][n];
        
        int x=0;//현재 방향
        int y=0;
        
        int dir=0;//방향 전환
        
        int num=1;//시작 숫자
        int end=factorial(n);//끝 숫자
        //System.out.println(end);
        
        //System.out.println(end);
        while(num<=end){
        	//System.out.println(num);
            arr[x][y]=num++;
            if(x+dx[dir]>=n || y+dy[dir]>=n || arr[x+dx[dir]][y+dy[dir]]!=0)//방향 전환 해야하는 경우
                dir=(dir+1)%3;
            x+=dx[dir];//다음 위치 구하기
            y+=dy[dir];
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        
        
        return answer;
    }
    static int factorial(int n){
        if(n==1) return 1;
        else return n+factorial(n-1);
    }
}
