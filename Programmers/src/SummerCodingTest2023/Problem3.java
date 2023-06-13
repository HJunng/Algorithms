package SummerCodingTest2023;

public class Problem3 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{0,1,4},{1,3,7},{2,2,3},{3,4,5}}));
	}
	public static long solution(int[][] tasks) {
        long answer = 0;

        long[] amount = new long[365];
        for(int i=0;i<tasks.length;i++){
            int days=tasks[i][1]-tasks[i][0]+1;
            for(int j=tasks[i][0];j<=tasks[j][1];j++){
                amount[i] += tasks[i][2]/days;
            }
        }

        return answer;
    }
}
