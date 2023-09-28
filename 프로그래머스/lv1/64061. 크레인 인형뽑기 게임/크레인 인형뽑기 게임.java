import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        int n = board.length; //보드 가로, 세로 길이
        
        //board의 i열에 인형을 스택으로 쌓기.
        for(int i=0;i<n;i++){
            stacks.add(new Stack<>());
            
            for(int j=n-1;j>=0;j--){
                if(board[j][i]==0) break;
                stacks.get(i).push(board[j][i]);
            }
        }
        
        Stack<Integer> bucket = new Stack<>(); //크레인 옆 바구니
        int answer=0; //사라진 인형 개수.
        for(int i=0;i<moves.length;i++){
            if(stacks.get(moves[i]-1).isEmpty()) continue;
            
            
            int crane = stacks.get(moves[i]-1).pop();
            
            if(!bucket.isEmpty() && bucket.peek()==crane){
                bucket.pop();
                answer+=2;
            }else{
                bucket.push(crane);
            }
        }
        
        return answer;
    }
}