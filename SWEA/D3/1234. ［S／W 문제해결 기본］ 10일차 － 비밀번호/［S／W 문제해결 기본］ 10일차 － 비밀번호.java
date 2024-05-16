import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            s = br.readLine().split(" ");

            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s[1].length();i++){
                char num = s[1].charAt(i);
                if(!stack.isEmpty() && stack.peek()==num){
                    stack.pop();
                } else{
                    stack.push(num);
                }
            }
            String str = "";
            for(char i: stack) str += i;

            sb.append("#"+t+" "+str+"\n");
        }
        System.out.println(sb);
    }
}
