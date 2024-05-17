import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        Map<Character,Integer> charNum = new HashMap<>();

        for(char i='A';i<='Z';i++){
            charNum.put(i,i-'A');
        }
        for(char i='a';i<='z';i++){
            charNum.put(i,i-'a'+26);
        }
        for(char i='0';i<='9';i++){
            charNum.put(i,i-'0'+52);
        }
        charNum.put('+',62); charNum.put('/',63);

        for (int t = 1; t <= T; t++) {

            // 1. 주어진 코드를 6자리 이진수로 바꿈.
            String code = br.readLine();
            String revert6 = "";
            for(int i=0;i<code.length();i++){
                int temp = charNum.get(code.charAt(i));
                String binary = Integer.toBinaryString(temp);
                for(int j=0;j<6-binary.length();j++){
                    revert6 += "0";
                }
                revert6 += binary;
            }

            // 총 길이를 8비트로 잘라서 다시 숫자로 바꾸고, 문자로 바꿈.
            String decode = "";
            for(int i=0;i<revert6.length();i+=8){
                String temp = revert6.substring(i,i+8);
                decode += (char) Integer.parseInt(temp,2);
            }
            sb.append("#"+t+" "+decode+"\n");
        }
        System.out.println(sb);
    }
}
