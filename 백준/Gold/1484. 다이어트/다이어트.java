import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int bef = 1;
        int now = 1;
        boolean isExist = false;
        while(now*now - bef*bef <1_000_000){
            if(now*now - bef*bef == G){
                System.out.println(now);
                isExist = true;
                now++;
            } else if(now*now - bef*bef > G){
                bef++;
            } else {
                now++;
            }
        }
        // 아무것도 없을 때  -1 출력.
        if(!isExist) System.out.println(-1);
    }
}