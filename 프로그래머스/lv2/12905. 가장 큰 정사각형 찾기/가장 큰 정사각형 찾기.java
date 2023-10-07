class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        // board 보다 한 행렬 더 만들기 -> 0번째 줄, 열
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        for(int i=0;i<board.length;i++){
            int tempSum=0;
            for(int j=0;j<board[0].length;j++){
                sum[i+1][j+1]=board[i][j]+sum[i][j+1]+tempSum;
                tempSum+=board[i][j];
                
            }
        }
        
        int maxLen=0;
        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum[i].length;j++){
                if(sum[i][j]>0){
                    
                    int ei = i+maxLen;
                    int ej = j+maxLen;
                    // 오른쪽 대각선으로 점차 나아가면서, 
                    // 0을 만나거나, board를 벗어나지 않을 때까지 크기 확인.
                    while(ei<sum.length && ej<sum[i].length && board[ei-1][ej-1]==1){
                        int tempSum = sum[ei][ej]-sum[i-1][ej]-sum[ei][j-1]+sum[i-1][j-1];
                        if(tempSum!=(ei-i+1)*(ei-i+1)) break;
                        
                        maxLen++;
                        
                        ei++; ej++;
                    }
                }
            }
        }
        

        return maxLen*maxLen;
    }
}