package SummerCodingTest2023;

public class Problem1 {

	public static void main(String[] args) {
		
		int[][] image = {{207,207,207,84},{207,207,84,255},{207,84,84,204},{84,255,207,0}};
		System.out.println(solution(image));
	}
	public static int[][] solution(int[][] image) {
        int n=image[0].length;
        int[][] answer = new int[n*2][n*2];

        int x=0,y=0;
        for(int i=0;i<answer[0].length;i++){
            for(int j=0;j<answer[0].length;j++){
                if(i>=n){
                    x=i-n+1;
                }
                if(j>=n){
                    y=j-n+1;
                }
                answer[i][j]=image[i-x][j-y];
                System.out.print(y+" ");
            }
            System.out.println();
        }
        return answer;
    }
}
