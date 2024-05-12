import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for(int t=1;t<=T;t++){

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean flag = true;
            for(int i=0;i<n;i++){
                char c = str.charAt(i);

                if(c=='(' || c=='{' || c=='[' || c=='<'){
                    stack.add(c);
                } else if(stack.isEmpty()) {
                    flag = false; break;
                } else if(c==')' && stack.peek() != '(') {
                    flag = false; break;
                } else if(c=='}' && stack.peek() != '{') {
                    flag = false; break;
                } else if(c==']' && stack.peek() != '[') {
                    flag = false; break;
                } else if(c=='>' && stack.peek() != '<'){
                    flag = false; break;
                } else {
                    stack.pop();
                }
            }
            if(flag){
                sb.append("#"+t+" 1\n");
            } else {
                sb.append("#"+t+" 0\n");
            }
        }
        System.out.println(sb);
    }
}
