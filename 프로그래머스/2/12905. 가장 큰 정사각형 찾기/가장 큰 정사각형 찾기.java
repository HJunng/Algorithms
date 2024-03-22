class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0; //가장 큰 정사각형의 한 변의 길이
        
        int n = board.length;
        int m = board[0].length;

        int[][] sum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            int rowSum = 0;
            for(int j=1;j<=m;j++){
                int top = (i==1)? 0 : sum[i-1][j];
                rowSum += board[i-1][j-1];
                sum[i][j] = top + rowSum;
                // System.out.print(sum[i][j]+" ");
            }
            // System.out.println();
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(board[i-1][j-1]==0) continue;
                
                int leg = answer; //answer보다 더 큰 정사각형이 있는지 확인하기 위해 answer+1을 한다.
                while(i+leg<=n && j+leg<=m){ // 주어진 board의 범위를 벗어나지는 않는지 확인.
                    int sqare = sum[i+leg][j+leg] - sum[i+leg][j-1] - sum[i-1][j+leg] + sum[i-1][j-1];
                    if(sqare == (leg+1)*(leg+1)){
                        leg++;
                        answer++;
                    }else{
                        break; // 정사각형이 되지 않기 때문에 더이상 탐색하지 않고 종료.
                    }
                }
                
            }
        }

        return answer*answer;
    }
}