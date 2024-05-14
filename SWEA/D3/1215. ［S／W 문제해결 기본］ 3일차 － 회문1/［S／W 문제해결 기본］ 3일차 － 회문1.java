import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int t = 1; t <= T; t++) {
            int len = Integer.parseInt(br.readLine());
            String[] board = new String[8];
            int cnt = 0;

            // 가로
            for(int i=0;i<8;i++){
                board[i] = br.readLine();
                StringBuilder word = new StringBuilder();
                for(int j=0;j<8;j++){
                    if(word.length()==len) word.deleteCharAt(0);
                    word.append(board[i].charAt(j));

                    if(word.length()!=len) continue;

                    if(isPalindrome(word)) {
                        cnt++;
                    }
                }
            }

            // 세로
            for(int i=0;i<8;i++){
                StringBuilder word = new StringBuilder();
                for(int j=0;j<8;j++){
                    if(word.length()==len) word.deleteCharAt(0);
                    word.append(board[j].charAt(i));

                    if(word.length()!=len) continue;

                    if(isPalindrome(word)) {
                        cnt++;
                    }
                }
            }

            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
    static boolean isPalindrome(StringBuilder word){
        int left=0;
        int right=word.length()-1;
        boolean flag = true;

        while(left<right){
            if(word.charAt(left)!=word.charAt(right)){
                flag = false; break;
            } else {
                left++; right--;
            }
        }
        return flag;
    }
}
